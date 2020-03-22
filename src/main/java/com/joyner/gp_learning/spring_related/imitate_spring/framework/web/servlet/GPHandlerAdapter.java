package com.joyner.gp_learning.spring_related.imitate_spring.framework.web.servlet;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

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
public class GPHandlerAdapter {

    /**
     * Given a handler instance, return whether or not this {@code HandlerAdapter}
     * can support it. Typical HandlerAdapters will base the decision on the handler
     * type. HandlerAdapters will usually only support one handler type each.
     * <p>A typical implementation:
     * <p>{@code
     * return (handler instanceof MyHandler);
     * }
     * @param handler handler object to check
     * @return whether or not this object can use the given handler
     */
    public boolean supports(Object handler) {
        return handler instanceof GPHandlerMapping;
    }

    /**
     * Use the given handler to handle this request.
     * The workflow that is required may vary widely.
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler handler to use. This object must have previously been passed
     * to the {@code supports} method of this interface, which must have
     * returned {@code true}.
     * @throws Exception in case of errors
     * @return ModelAndView object with the name of the view and the required
     * model data, or {@code null} if the request has been handled directly
     */
    @Nullable
    public GPModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            GPHandlerMapping handlerMapping = (GPHandlerMapping)handler;

            Object[] methodParamValues = new Object[handlerMapping.getMethod().getParameterCount()];
            Class[] methodTypes = handlerMapping.getMethod().getParameterTypes();

            //1.获取handlerMapping的参数索引位置,并处理
            Map<String,Integer> reqParaNameIndexes = handlerMapping.getReqParaNameIndexes();
            for (Map.Entry<String,Integer> reqParaNameEntry : reqParaNameIndexes.entrySet()) {
                String key = reqParaNameEntry.getKey();
                int paramIndex = reqParaNameEntry.getValue();
                if (key.equals(HttpServletRequest.class.getName())) {
                    //处理HttpServletRequest
                    methodParamValues[paramIndex] = request;
                } else if (key.equals(HttpServletResponse.class.getName())) {
                    //处理HttpServletResponse
                    methodParamValues[paramIndex] = response;
                } else {
                    String reqValue = request.getParameter(reqParaNameEntry.getKey());
                    Object convertedValue = convertType(methodTypes[reqParaNameEntry.getValue()], reqValue);
                    methodParamValues[paramIndex] = convertedValue;
                }

            }

            //开始调用方法
            Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(),methodParamValues);

            Class returnType = handlerMapping.getMethod().getReturnType();


            if (!(returnType == GPModelAndView.class)) {
                return null;
            }
            return (GPModelAndView)result;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

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
}
