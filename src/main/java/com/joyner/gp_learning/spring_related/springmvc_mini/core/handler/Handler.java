package com.joyner.gp_learning.spring_related.springmvc_mini.core.handler;

import com.joyner.gp_learning.spring_related.springmvc_mini.core.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
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
public class Handler {

    private Object controller;
    private Method method;
    private Pattern pattern;
    private Map<String,Integer> paramIndexMapping = new HashMap<>();

    public Handler(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
        initParamIndexMapping(this.method);
    }

    private void initParamIndexMapping(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        /**
         * 处理HttpServletRequest和HttpServletResponse参数
         */
        for (int i = 0; i < parameterTypes.length; i++) {
            Class type = parameterTypes[i];
            if (type.equals(HttpServletRequest.class) || type.equals(HttpServletResponse.class) ) {
                paramIndexMapping.put(type.getName(), i);
            }
        }
        /**
         * 处理使用了注解GPRequestParam的参数
         */
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int paramIdx = 0; paramIdx < parameterAnnotations.length; paramIdx++) {
            for (int annotationIdx = 0; annotationIdx < parameterAnnotations[paramIdx].length; annotationIdx++) {
                Annotation annotation = parameterAnnotations[paramIdx][annotationIdx];
                if (annotation instanceof GPRequestParam) {
                    GPRequestParam gpRequestParam = (GPRequestParam)annotation;
                    String paramName = gpRequestParam.value();
                    paramIndexMapping.put(paramName, paramIdx);
                }
            }
        }
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Map<String, Integer> getParamIndexMapping() {
        return paramIndexMapping;
    }
}
