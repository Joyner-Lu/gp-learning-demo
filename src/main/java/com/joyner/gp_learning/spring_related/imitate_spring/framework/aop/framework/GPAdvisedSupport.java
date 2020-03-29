package com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.aspectj.GPAspectJAfterAdvice;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.aspectj.GPAspectJAfterThrowingAdvice;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.aspectj.GPAspectJMethodBeforeAdvice;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept.GPMethodInterceptor;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class GPAdvisedSupport {

    private Object target;
    private Class targetClass;
    private Pattern pointCutClassPattern;


    private GPAopConfig aopConfig;
    private transient Map<Method, List<Object>> methodCache = new HashMap<>();

    public GPAdvisedSupport(GPAopConfig aopConfig) {
        this.aopConfig = aopConfig;
        init();
    }

    private void init() {
        // //为了方便处理，把前面的修饰符去掉，把方法匹配的部分去掉，并将其变成正则
        String pointCutExpression = aopConfig.getPointCut();
        pointCutExpression = pointCutExpression.substring(pointCutExpression.lastIndexOf(" ") + 1);
        pointCutExpression = pointCutExpression.substring(0, pointCutExpression.indexOf("("));
        pointCutExpression = pointCutExpression.replaceAll("\\.\\.\\*", "####");
        pointCutExpression = pointCutExpression.replaceAll("\\.", "\\\\.");
        pointCutExpression = pointCutExpression.replaceAll("####", ".*");
        pointCutClassPattern = Pattern.compile(pointCutExpression);
    }

    public Class getTargetClass() {
        return target.getClass();
    }

    public boolean pointCutMatch() {
        return pointCutClassPattern.matcher(this.getTargetClass().getName()).matches();
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    private List<Object> parseMethodInterceptorChain(Method method) {
        try {
            //1.获取target的方法
            //2.检查方法是否匹配切点
            //3.如果匹配，则获取通知列表缓存到methodCache
            Method[] methods = getTargetClass().getMethods();
            //获取增强的方法
            String aspectClassName = aopConfig.getAspectClass();
            Class aspectClass = Class.forName(aspectClassName);
            Method[] aspectClassMethods = aspectClass.getMethods();
            Map<String, Method> aspectMethodMap = new HashMap<>();
            for (Method aspectClassMethod : aspectClassMethods) {
                aspectMethodMap.put(aspectClassMethod.getName(), aspectClassMethod);
            }
            Object aspectInstance = aspectClass.newInstance();
            //方法拦截器链
            List<Object> advices = new ArrayList<>();
            String methodName = getTargetClass().getName() + "." + method.getName();
            boolean isMatch = pointCutClassPattern.matcher(methodName).matches();
            if (isMatch && advices.size() == 0) {
                //只需要初始化一次
                String aspectBefore = aopConfig.getAspectBefore();
                if (!StringUtils.isEmpty(aspectBefore)) {
                    Method m = aspectMethodMap.get(aopConfig.getAspectBefore());
                    GPMethodInterceptor gpMethodInterceptor = new GPAspectJMethodBeforeAdvice(m, aspectInstance);
                    advices.add(gpMethodInterceptor);
                }

                String aspectAfter = aopConfig.getAspectAfter();
                if (!StringUtils.isEmpty(aspectAfter)) {
                    Method m = aspectMethodMap.get(aopConfig.getAspectAfter());
                    GPMethodInterceptor gpMethodInterceptor = new GPAspectJAfterAdvice(m, aspectInstance);
                    advices.add(gpMethodInterceptor);
                }

                String aspectAfterThrow = aopConfig.getAspectAfterThrow();
                if (!StringUtils.isEmpty(aspectAfterThrow)) {
                    Method m = aspectMethodMap.get(aopConfig.getAspectAfterThrow());
                    GPAspectJAfterThrowingAdvice gpMethodInterceptor = new GPAspectJAfterThrowingAdvice(m, aspectInstance);
                    String aspectAfterThrowingName = aopConfig.getAspectAfterThrowingName();
                    if (!StringUtils.isEmpty(aspectAfterThrowingName)) {
                        gpMethodInterceptor.setAspectAfterThrowingName(aspectAfterThrowingName);
                    }
                    advices.add(gpMethodInterceptor);
                }
            }
            return advices;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Class targetClass) {
        List<Object> result = null;
        if (pointCutMatch() ) {
            result = methodCache.get(method);
            if (result == null || result.size() == 0) {
                //解析方法拦截器链
                result = parseMethodInterceptorChain(method);
                methodCache.put(method, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String ex = "public .* com.gupaoedu.vip.spring.demo.service..*Service..*(.*)";
        //为了方便处理，把前面的修饰符去掉，把方法匹配的部分去掉，并将其变成正则
        ex = ex.substring(ex.lastIndexOf(" ") + 1);
        ex = ex.substring(0, ex.indexOf("("));
        ex = ex.replaceAll("\\.\\.\\*", "####");
        ex = ex.replaceAll("\\.", "\\\\.");
        ex = ex.replaceAll("####", ".*");
        //最后输出
        //com\.gupaoedu\.vip\.spring\.demo\.service.*Service.*

        System.out.println(ex);
    }
}
