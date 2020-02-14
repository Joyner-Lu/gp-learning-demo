package com.joyner.gp_learning.mvcframework.core.v3.servlet;

import com.joyner.gp_learning.mvcframework.core.annotation.*;
import com.joyner.gp_learning.mvcframework.core.handler.Handler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class GPDispatcherServlet extends HttpServlet {

    /**
     * 配置文件
     */
    private Properties contextConfig = new Properties();

    /***
     * 保存扫描到的类
     */
    private List<Class> classes = new ArrayList<>();

    /**
     * ioc容器(注册式单例)
     */
    private Map<String, Object> ioc = new HashMap<>();

    /**
     * 保存url和Method的映射关系
     */
    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            //1.加载配置文件
            doLoadConfig(config);
            //2.扫描相关的类
            doScanner();
            //3.初始化IOC容器(工程方法的体现)
            doInitIOC();
            //4.完成依赖注入
            doDI();
            //5.初始化handlerMapping
            doHandlerMapping();

            System.out.println("My spring mvc init finished.");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.getWriter().write("500 Detail Info:" + Arrays.toString(ex.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        /**
         * 1.获取uri
         * 2.找到对应handler
         * 3.动态构造参数
         * 4.执行
         */
        String uri = req.getRequestURI();
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (h.getPattern().matcher(uri).matches()) {
                handler = h;
                break;
            }
        }
        if (handler == null) {
            resp.getWriter().write("404 Not Found.");
            return;
        }
        Class[] parameterTypes = handler.getMethod().getParameterTypes();
        Object[] params = new Object[parameterTypes.length];

        Map<String, Integer> paramIndexMapping = handler.getParamIndexMapping();

        //动态构造参数
        Set<Map.Entry<String, Integer>> entries = paramIndexMapping.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int idx = entry.getValue();
            String paramName = entry.getKey();
            if (HttpServletRequest.class.getName().equals(paramName)) {
                params[idx] = req;
            } else if (HttpServletResponse.class.getName().equals(paramName)) {
                params[idx] = resp;
            } else {
                String val = req.getParameter(paramName);
                Object r = convertType(parameterTypes[idx], val);
                params[idx] = r;
            }

        }

        //4.执行
        Object val = handler.getMethod().invoke(handler.getController(), params);
        if (val == null || val instanceof Void) {
            return;
        }
        resp.getWriter().write(val.toString());
    }


    private Object convertType(Class parameterType, String val) {
        Object r = val;
        if (parameterType.equals(Integer.class)) {
            r = Integer.valueOf(val);
        } else if (parameterType.equals(Double.class)) {
            r = Double.valueOf(val);
        }
        return r;
    }


    private void doInitIOC() throws Exception {
        /**
         * 1.默认的bean的名称是类的SimpleName首字母小写
         * 2.如果注解使用了自定义的名称则使用自定义的名称
         * 3.为了方便，我们额外把类实现的接口的类名也作为bean的名称，并且把bean的实例也存储进去
         * TODO 这样做会有个问题，例如一个接口有多个实现类，可能会出现覆盖的问题。
         * 例如B实现A接口，C实现A接口，则存储到容器里面的接口对应的实例可能只有B或者C
         */
        if (classes.size() == 0) {
            return;
        }

        for (Class clz : classes) {
            String beanName = convertBeanName(clz);
            Object bean = clz.newInstance();
            ioc.put(beanName, bean);

            Class<?>[] interfaces = clz.getInterfaces();
            for (Class interfaceClz : interfaces) {
                ioc.put(interfaceClz.getName(), bean);
            }
        }


    }

    private String convertBeanName(Class clz) {
        String defaultBeanName = toLowerCase(clz.getSimpleName());
        String value = "";
        if (clz.isAnnotationPresent(GPController.class)) {
            GPController gpController = (GPController) clz.getAnnotation(GPController.class);
            value = gpController.value();
        } else if (clz.isAnnotationPresent(GPService.class)) {
            GPService gpService = (GPService) clz.getAnnotation(GPService.class);
            value = gpService.value();
        }
        if (!value.isEmpty()) {
            defaultBeanName = value;
        }
        return defaultBeanName;

    }

    private String toLowerCase(String str) {
        //大小写字母ASCII相差32，且小写字母的值要大
        char[] charArr = str.toCharArray();
        charArr[0] += 32;
        return new String(charArr);
    }

    private void doDI() throws Exception {
        /**
         * 1.找到类的所有字段，如果注入了GPAutowired则对其进行注入
         * 2.如果GPAutowired使用自定义的value，则使用value 作为beanName
         * 2.如果字段的类型是类，则beanName使用类的simpleName首字母小写，如果是接口则使用起名称为beanName
         * */
        if (classes.size() == 0) {
            return;
        }

        Set<Map.Entry<String, Object>> entries = ioc.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            Class clz = entry.getValue().getClass();
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(GPAutowired.class)) {
                    GPAutowired gpAutowired = (GPAutowired) field.getAnnotation(GPAutowired.class);
                    Class fieldType = field.getType();
                    String fieldBeanName = getDIBeanName(fieldType, gpAutowired);
                    //从容器查询bean
                    Object fieldBeanVal = ioc.get(fieldBeanName);
                    if (fieldBeanVal == null) {
                        throw new RuntimeException("容器不存在对应的bean, 无法完成注入，类：" + clz.getName() + ",字符：" + field.getName());
                    }
                    field.setAccessible(true);
                    field.set(entry.getValue(), fieldBeanVal);
                }
            }
        }


    }

    private String getDIBeanName(Class fieldType, GPAutowired gpAutowired) {
        String beanName = "";
        if (fieldType.isInterface()) {
            beanName = fieldType.getName();
        } else {
            beanName = convertBeanName(fieldType);
        }
        String value = gpAutowired.value();
        if (!value.isEmpty()) {
            beanName = value;
        }
        return beanName;
    }

    private void doHandlerMapping() throws Exception {
        /**
         * 1.对使用了GPController注解的类进行处理
         * 2.解析GPRequestMapping,构建url
         */
        if (classes.size() == 0) {
            return;
        }

        Set<Map.Entry<String, Object>> entries = ioc.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            Class clz = entry.getValue().getClass();
            if (clz.isAnnotationPresent(GPController.class)) {
                String basePath = "";
                if (clz.isAnnotationPresent(GPRequestMapping.class)) {
                    GPRequestMapping gpRequestMapping = (GPRequestMapping) clz.getAnnotation(GPRequestMapping.class);
                    basePath = gpRequestMapping.value();
                }
                //获取publish方法
                Method[] methods = clz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(GPRequestMapping.class)) {
                        GPRequestMapping gpRequestMapping = (GPRequestMapping) method.getAnnotation(GPRequestMapping.class);
                        String path = basePath + gpRequestMapping.value();
                        //兼容 /demo/query//
                        path = path.replaceAll("/+", "/");
                        Pattern pattern = Pattern.compile(path);
                        handlerMapping.add(new Handler(entry.getValue(), method, pattern));
                        System.out.println("Mapped :" + path + "," + method);
                    }
                }
            }
        }

    }

    private void doLoadConfig(ServletConfig config) throws Exception {
        //1.从ServletConfig获取init-param参数
        //2.从类路径读取文件流
        //3.加载到内存中
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        contextConfig.load(inputStream);
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private void doScanner() throws Exception {
        /**
         * 1.获取扫描包路径
         * 2.将包路径下面的类添加到classes
         */
        String scanPackage = contextConfig.getProperty("scanPackage");
        loadClassNames(scanPackage);
    }

    private void loadClassNames(String scanPackage) throws Exception {
        String pkgPath = scanPackage.replaceAll("\\.", "/");
        URL url = this.getClass().getClassLoader().getResource(pkgPath);
        File pkgFile = new File(url.getPath());
        for (File f : pkgFile.listFiles()) {
            if (f.isFile()) {
                if (f.getName().endsWith(".class")) {
                    String clzName = scanPackage + "." + f.getName();
                    Class clz = Class.forName(clzName.replaceAll("\\.class", ""));
                    //只有添加了注解GPController和注解GPService的类才添加到classes容器
                    if (clz.isAnnotationPresent(GPController.class) || clz.isAnnotationPresent(GPService.class)) {
                        classes.add(clz);
                    }
                }
            } else {
                //继续递归
                loadClassNames(scanPackage + "." + f.getName());
            }
        }
    }
}
