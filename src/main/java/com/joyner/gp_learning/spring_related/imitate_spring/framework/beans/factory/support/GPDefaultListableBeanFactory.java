package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.support;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPAutowired;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPController;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPService;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.GPBeanWrapper;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.GPBeanFactory;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanDefinition;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanPostProcessor;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPAbstractApplicationContext;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPApplicationContextAware;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


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
public class GPDefaultListableBeanFactory implements GPBeanFactory {

    private Map<String, GPBeanDefinition> beanDefinitionMap = new HashMap<>();
    private final Map<String, GPBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>(16);
    private GPBeanPostProcessor gpBeanPostProcessor;

    /**
     * Cache of singleton objects: bean name --> bean instance
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    @Override
    public Object getBean(String beanName) {

        GPBeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        //创建bean。这是调用构造方法初始化
        GPBeanWrapper beanWrapper = createBeanInstance(beanName, beanDefinition);
        //依赖注入处理
        populateBean(beanName, beanDefinition, beanWrapper.getWrappedInstance());
        Object exposedObject = beanWrapper.getWrappedInstance();
        /**
         * 对bean做最后的处理，例如给bean生成代理等
         */
        exposedObject = initializeBean(beanName, exposedObject, beanDefinition);

        return exposedObject;
    }

    private Object initializeBean(String beanName, Object exposedObject, GPBeanDefinition beanDefinition) {


        //处理BeanPostProcessors
        Object wrappedBean = exposedObject;
        wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
        //调用init方法，暂不实现
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName); 

        return wrappedBean;

    }
    private Object applyBeanPostProcessorsBeforeInitialization(Object wrappedBean, String beanName) {


        Object result = gpBeanPostProcessor.postProcessBeforeInitialization(wrappedBean, beanName);
        return result;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, GPBeanDefinition beanDefinition) {
    }

    private Object applyBeanPostProcessorsAfterInitialization(Object wrappedBean, String beanName) {
        Object result = gpBeanPostProcessor.postProcessAfterInitialization(wrappedBean, beanName);
        return result;
    }

    private void populateBean(String beanName, GPBeanDefinition gpBeanDefinition, Object wrappedInstance) {
        try {
            doDI(beanName, gpBeanDefinition, wrappedInstance);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void doDI(String beanName, GPBeanDefinition gpBeanDefinition, Object wrappedInstance) throws Exception {
        /**
         * 1.找到类的所有字段，如果注入了GPAutowired则对其进行注入
         * 2.如果GPAutowired使用自定义的value，则使用value 作为beanName
         * 2.如果字段的类型是类，则beanName使用类的simpleName首字母小写，如果是接口则使用起名称为beanName
         * */
        Class clz = wrappedInstance.getClass();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(GPAutowired.class)) {
                GPAutowired gpAutowired = (GPAutowired) field.getAnnotation(GPAutowired.class);
                Class fieldType = field.getType();
                String fieldBeanName = getDIBeanName(fieldType, gpAutowired);
                //从容器查询bean
                GPBeanWrapper gpBeanWrapper = factoryBeanInstanceCache.get(fieldBeanName);
                Object fieldBeanVal = null;
                if (gpBeanWrapper == null) {
                    fieldBeanVal = getBean(fieldBeanName);
                } else {
                    fieldBeanVal = gpBeanWrapper.getWrappedInstance();
                }
                field.setAccessible(true);
                field.set(wrappedInstance, fieldBeanVal);
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

    private String toLowerCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }




    private GPBeanWrapper createBeanInstance(String beanName, GPBeanDefinition gpBeanDefinition) {
        //1.获取beanName获取GPBeanDefinition
        //2.判断该bean是否是单例的
        //   2.1 是单例，先尝试从缓存(singletonObjects)拿
        //   2.2 非单例，则直接创建对象
        //3.最后放入到BeanWrapper里面
        try {
            Object beanInstance = null;
            if (gpBeanDefinition.isSingleton()) {
                //单例冲缓存获取
                beanInstance = singletonObjects.get(beanName);
            }
            if (beanInstance == null) {
                //非单例或者首次获取创建
                Class beanClz = Class.forName(gpBeanDefinition.getBeanClassName());
                beanInstance = beanClz.newInstance();
                if (gpBeanDefinition.isSingleton()){
                    singletonObjects.put(beanName, beanInstance);
                }
            }
            GPBeanWrapper beanWrapper = new GPBeanWrapper(beanInstance);
            factoryBeanInstanceCache.put(beanName, beanWrapper);
            return beanWrapper;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public <T> T getBean(Class<T> clz) {
        return (T) getBean(clz.getName());
    }

    @Override
    public void registerBeanDefinition(String beanName, GPBeanDefinition beanDefinition) {
        if (getBeanDefinition(beanName) != null) {
            throw new RuntimeException("beanName:" + beanName + ",有重复的beanName已经被定义，当前bean的class:" + beanDefinition.getBeanClassName());
        }
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public GPBeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public void setBeanPostProcessor(GPBeanPostProcessor beanPostProcessor) {
        this.gpBeanPostProcessor = beanPostProcessor;
    }

    @Override
    public GPBeanPostProcessor getBeanPostProcessor() {
        return gpBeanPostProcessor;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        String[] strArr = new String[beanDefinitionMap.size()];
        return beanDefinitionMap.keySet().toArray(strArr);
    }
}
