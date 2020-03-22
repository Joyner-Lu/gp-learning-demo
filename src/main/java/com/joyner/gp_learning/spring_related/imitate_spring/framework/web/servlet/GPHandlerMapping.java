package com.joyner.gp_learning.spring_related.imitate_spring.framework.web.servlet;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPRequestParam;
import lombok.Data;

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
@Data
public class GPHandlerMapping {

    private Object controller;
    private Method method;
    private Pattern pattern;
    //请求名称在方法里面的索引位置
    private Map<String, Integer> reqParaNameIndexes = new HashMap();

    public GPHandlerMapping() {

    }

    public GPHandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.controller = controller;
        this.method = method;
        init();
    }

    private void init() {
        Class<?>[] parameterTypes = method.getParameterTypes();

        Annotation[][] methodParameterAnnotations = this.method.getParameterAnnotations();
        for (int paramIdx = 0; paramIdx < methodParameterAnnotations.length; paramIdx++) {
            //1.处理参数索引位置
            for (Annotation annotation : methodParameterAnnotations[paramIdx]) {
                if (annotation instanceof GPRequestParam) {
                    GPRequestParam gpRequestParam = (GPRequestParam)annotation;
                    String reqParaName = gpRequestParam.value();
                    reqParaNameIndexes.put(reqParaName, paramIdx);
                }
            }
            //2.处理HttpServletRequest和HttpServletResponse在方法的索引位置（如果有的话）
            Class paramType = parameterTypes[paramIdx];
            if (paramType == HttpServletRequest.class) {
                reqParaNameIndexes.put(HttpServletRequest.class.getName(), paramIdx);
            }
            if (paramType == HttpServletResponse.class) {
                reqParaNameIndexes.put(HttpServletResponse.class.getName(), paramIdx);
            }
        }
    }




}
