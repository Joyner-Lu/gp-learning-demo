package com.joyner.gp_learning.spring_related.imitate_spring.framework.web.servlet;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPController;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPRequestMapping;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
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

    private GPApplicationContext context;

    private List<GPHandlerMapping> handlerMappings = new ArrayList<>();


    private List<GPHandlerAdapter> handlerAdapters = new ArrayList<>();

    private List<GPViewResolver> viewResolvers = new ArrayList<>();


    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.获取配置文件路径
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        //2.初始化容器
        context = new GPApplicationContext(contextConfigLocation);
        //3.初始化9大组件
        initStrategies(context);

    }

    private void initStrategies(GPApplicationContext context) {
        //1.初始化多文件上传解析器
        initMultipartResolver(context);
        //2.初始化本地化解析器
        initLocaleResolver(context);
        //3.初始化主体解析器
        initThemeResolver(context);
        //4.初始化handlerMappings
        initHandlerMappings(context);
        //5.初始化handlerMappings适配器，主要是参数适配
        initHandlerAdapters(context);
        //6.初始化异常解析器
        initHandlerExceptionResolvers(context);
        //7.初始化请求到viewName解析器
        initRequestToViewNameTranslator(context);
        //8.初始化试图解析器
        initViewResolvers(context);
        //9.初始化FlashMapManager
        initFlashMapManager(context);
    }

    private void initFlashMapManager(GPApplicationContext context) {
    }

    private void initViewResolvers(GPApplicationContext context) {
        //正常来说是要去查找hViewResolver但是这里为了简单使用一个默认的实现
        //为了简单这里只实现一种ViewResolver
        Properties config = context.getConfig();
        GPViewResolver gpViewResolver = new GPViewResolver(config.getProperty("templateRoot"));
        viewResolvers.add(gpViewResolver);
    }

    private void initRequestToViewNameTranslator(GPApplicationContext context) {
    }

    private void initHandlerExceptionResolvers(GPApplicationContext context) {
    }

    private void initHandlerAdapters(GPApplicationContext context) {
        //正常来说是要去查找handlerAdapters但是这里为了简单使用一个默认的实现
        //为了简单这里只实现一种adapter
        GPHandlerAdapter handlerAdapter = new GPHandlerAdapter();
        handlerAdapters.add(handlerAdapter);
    }

    private void initHandlerMappings(GPApplicationContext context) {
        //1.获取所有的beanName
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            Class beanClz = bean.getClass();
            //2.处理了使用GPController注解的类
            if (!beanClz.isAnnotationPresent(GPController.class)) {
                continue;
            }
            //3.获取basePath
            String basePath = "";
            if (beanClz.isAnnotationPresent(GPRequestMapping.class)) {
                GPRequestMapping requestMapping = (GPRequestMapping) beanClz.getAnnotation(GPRequestMapping.class);
                basePath = requestMapping.value();
            }
            String url = "";
            //4.遍历控制器的public方法
            Method[] methods = beanClz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(GPRequestMapping.class)) {
                    continue;
                }
                //处理使用了GPRequestMapping的方法
                GPRequestMapping requestMapping = method.getDeclaredAnnotation(GPRequestMapping.class);
                String path = requestMapping.value();
                url = basePath + path;
                url = url.replaceAll("/+", "/");

                Pattern pattern = Pattern.compile(url);
                GPHandlerMapping handlerMapping = new GPHandlerMapping(pattern, bean, method);
                handlerMappings.add(handlerMapping);
            }

        }

    }

    private void initThemeResolver(GPApplicationContext context) {
    }

    private void initLocaleResolver(GPApplicationContext context) {
    }

    private void initMultipartResolver(GPApplicationContext context) {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatcher(req, resp);
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        if (uri.contains("favicon.ico")) {
            return;//禁用浏览器请求该图标
        }
        //1.根据url获取handlerMapping
        GPHandlerMapping handlerMapping = getHandler(req);
        if (handlerMapping == null) {
            processDispatchResult(req, resp, null, new GPModelAndView("404"));
            return;
        }
        //2.获取对应的HandlerAdapter
        GPHandlerAdapter ha = getHandlerAdapter(handlerMapping);
        //3.调用handle方法获取GPModelAndView
        GPModelAndView modelAndView = null;
        try {
            modelAndView = ha.handle(req, resp, handlerMapping);
            if (modelAndView == null) {
                return;
            }
        } catch (Exception e) {
            String detail = e.getMessage();
            String stackTrace = Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]","") .replaceAll("\\s","\r\n");
            Map<String, Object> errorModel = new HashMap<>();
            errorModel.put("detail", detail);
            errorModel.put("stackTrace", stackTrace);
            processDispatchResult(req, resp, null, new GPModelAndView("500", errorModel));
            return;
        }
        //4.解析试图并处理
        processDispatchResult(req, resp, handlerMapping, modelAndView);

    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, GPHandlerMapping handlerMapping, GPModelAndView modelAndView) {
        if (this.viewResolvers.isEmpty()) {
            return;
        }
        for (GPViewResolver viewResolver : viewResolvers) {
            GPView gpView = viewResolver.resolveViewName(modelAndView.getView(), null);
            if (gpView != null) {
                gpView.render(modelAndView.getModel(), req, resp);
                return;
            }
        }
    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMapping handlerMapping) {
        for (GPHandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(handlerMapping)) {
                return handlerAdapter;
            }
        }
        return null;
    }

    private GPHandlerMapping getHandler(HttpServletRequest req) {
        String uri = req.getRequestURI();
        for (GPHandlerMapping handlerMapping : handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(uri);
            if (matcher.matches()) {
                return handlerMapping;
            }
        }

        return null;
    }
}
