package com.joyner.gp_learning.spring_related.mvcframework.core.v1.servlet;

import com.joyner.gp_learning.spring_related.mvcframework.core.annotation.*;

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
import java.util.*;

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

    private Map<String, Object> ioc = new HashMap<>();
    private Map<String, Method> handlerMapping = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);



    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {

        try {
            //处理逻辑
            //1.获取url
            String uri = req.getRequestURI();
            //2.从handlerMapping里面查询到方法
            Method method = handlerMapping.get(uri);
            if (method == null) {
                resp.getWriter().write("404 Not Found.");
                return;
            }
            Class clz = method.getDeclaringClass();
            //3.从容器查询到been
            String beanName = constructBeanName(clz);
            Object bean = ioc.get(beanName);
            //4.执行
            Class[] parameterTypes = method.getParameterTypes();
            Object[] params = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Class type = parameterTypes[i];
                if (type.equals(HttpServletRequest.class)) {
                    params[i] = req;
                } else if (type.equals(HttpServletResponse.class)) {
                    params[i] = resp;
                } else {
                    Annotation[][] annotations = method.getParameterAnnotations();
                    for (int paramIdx = 0; paramIdx < annotations.length; paramIdx++) {
                        for (int annotationIndx = 0; annotationIndx < annotations[paramIdx].length; annotationIndx++) {
                            Annotation annotation = annotations[paramIdx][annotationIndx];
                            if (annotation != null) {
                                if (annotation instanceof GPRequestParam) {
                                    GPRequestParam gpRequestParam = (GPRequestParam)annotation;
                                    String paramName = gpRequestParam.value();
                                    String val = req.getParameter(paramName);
                                    Object convertResult = convertType(type, val);
                                    params[i]  = convertResult;
                                }
                            }
                        }

                    }
                }
            }
            method.invoke(bean, params);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private Object convertType(Class type, String val) {
        Object r = val;
        if (type.equals(Integer.class)) {
            r = Integer.valueOf(val);
        } else if(type.equals(Double.class)) {
            r = Double.valueOf(val);
        }
        return r;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            //1.获取主配置文件并解析
            String contextConfigLocation = servletConfig.getInitParameter("contextConfigLocation");
            //2.根据主配置文件的扫描表，扫描类
            InputStream is = GPDispatcherServlet.class.getResourceAsStream("/" + contextConfigLocation);
            Properties properties = new Properties();
            properties.load(is);
            String scanPackage = properties.getProperty("scanPackage");
            List<String> classNames = doFind(scanPackage, new ArrayList<String>());

            //3.扫描完毕之后，进行初始化IOC容器
            for (String clzName : classNames) {
                //只有注释了GPController和GPService注解的才初始化
                Class clz = Class.forName(clzName);
                if (clz.isAnnotationPresent(GPController.class) ||
                        clz.isAnnotationPresent(GPService.class)) {
                    String beanName = constructBeanName(clz);
                    ioc.put(beanName, clz.newInstance());
                    //特殊处理把，接口的名称也作为bean存进去，方便后面处理
                    Class[] interfaces = clz.getInterfaces();
                    for (Class i : interfaces) {
                        ioc.put(i.getName(),clz.newInstance());
                    }
                }
            }
            //4.实现注入的功能
            for(String clzName : classNames) {
                Class clz = Class.forName(clzName);
                String beanName = constructBeanName(clz);
                Field[] fields = clz.getDeclaredFields();
                for (Field field : fields) {
                    GPAutowired annotation = (GPAutowired)field.getAnnotation(GPAutowired.class);
                    if (annotation != null) {
                        String fieldBeanName = findBeanName(field, annotation);
                        Object fieldBean = ioc.get(fieldBeanName);
                        field.setAccessible(true);
                        field.set(ioc.get(beanName), fieldBean);
                    }
                }
            }
            //5.将url和method的进行对应
            for (String clzName : classNames) {
                Class clz = Class.forName(clzName);
                String basePath = "";
                if (clz.isAnnotationPresent(GPRequestMapping.class)) {
                    //获取controller上面的路径
                    GPRequestMapping gpRequestMapping = (GPRequestMapping)clz.getAnnotation(GPRequestMapping.class);
                    basePath = gpRequestMapping.value();
                }
                if (clz.isAnnotationPresent(GPController.class)) {

                    Method[] methods = clz.getMethods();
                    for (Method method: methods) {
                        String path = "";
                        //使用了GPRequestMapping注解的才处理
                        if (method.isAnnotationPresent(GPRequestMapping.class)) {
                            GPRequestMapping methodAnnotation = (GPRequestMapping)method.getAnnotation(GPRequestMapping.class);
                            path += basePath + "/" + methodAnnotation.value();
                            path = path.replaceAll("/+", "/");
                            handlerMapping.put(path, method);
                        }
                    }

                }
            }
            System.out.println("GP MVC init finished");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private String findBeanName(Field field, GPAutowired annotation) {
        String beanName = "";
        Class clz = field.getType();
        if (clz.isInterface()) {
            beanName = clz.getName();

        } else {
            beanName = toLowerCase(clz.getSimpleName());
        }

        if (!annotation.value().isEmpty()) {
            beanName = annotation.value();
        }
        return beanName;
    }

    private String constructBeanName(Class clz) {
        String beanName = toLowerCase(clz.getSimpleName());
        String value = "";
        if (clz.isAnnotationPresent(GPService.class)) {
            GPService gpService = (GPService)clz.getAnnotation(GPService.class);
            value = gpService.value();
        } else if (clz.isAnnotationPresent(GPController.class)){
            GPController gpController = (GPController)clz.getAnnotation(GPController.class);
            value = gpController.value();
        }
        if (!value.isEmpty()) {
            beanName = value;
        }

        return beanName;
    }

    private static String toLowerCase(String str) {
        /**
         * 小写字母和大写字母的ASCII值相差32，且小写字母比大写字母的ASCII值大
         */
        char[] c = str.toCharArray();
        c[0] += 32;
        return new String(c);
    }


    private List<String> doFind(String scanPackage, List<String> classes) {
        String scanPath = GPDispatcherServlet.class.getResource("/" + scanPackage.replaceAll("\\.", "/")).getPath();
        File file = new File(scanPath);
        for (File f : file.listFiles()) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                //1.是类文件
                classes.add(scanPackage + "." + f.getName().replaceAll("\\.class", ""));
            } else {
                //2.是目录
                doFind(scanPackage + "." + f.getName(), classes);
            }
        }
        return classes;
    }
}
