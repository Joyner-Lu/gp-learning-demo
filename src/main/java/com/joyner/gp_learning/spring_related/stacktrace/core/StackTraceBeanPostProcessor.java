package com.joyner.gp_learning.spring_related.stacktrace.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
public class StackTraceBeanPostProcessor implements BeanPostProcessor {

    private Properties config = null;
    private StackTraceInvocation stackTraceInvocation;
    private String scanPackage;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object instance = bean;
        if (config == null) {
            //初始化配置
            initConfig();
        }

        if (bean.getClass().getName().contains(scanPackage)) {
            //对其进行增强
            stackTraceInvocation = new StackTraceInvocation(bean);
            instance = stackTraceInvocation.getInstance();
        }

        return instance;

    }

    private void initConfig() {

        try {
            config = new Properties();
            //加载配置
            ClassPathResource classPathResource = new ClassPathResource("stacktrack_config/stacktrack_config.properties");
            InputStream inputStream = classPathResource.getInputStream();
            config.load(inputStream);
            scanPackage = config.getProperty("scanPackage");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

}
