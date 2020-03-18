package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.support;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPController;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.annotation.GPService;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanDefinition;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
public class GPBeanDefinitionReader {

    private final static String SCAN_PACKAGE = "scanPackage";
    private String[] configLocations;
    private Properties appConfig = new Properties();
    private List<String> scannedClassNames = new ArrayList<>();

    public GPBeanDefinitionReader(String... configLocations) {
        this.configLocations = configLocations;
        //1.加载配置
        loadAppConfig();
        //2.扫描
        doScan();
    }

    public List<GPBeanDefinition> loadBeanDefinitions() {
        List<GPBeanDefinition> definitions = new ArrayList<>();
        try {

            for (String registerClzName : scannedClassNames) {
                Class registerClz = Class.forName(registerClzName);
                String beanName = convertBeanName(registerClz);
                GPBeanDefinition beanDefinition = doCreateBeanDefinition(beanName, registerClzName);
                definitions.add(beanDefinition);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return definitions;
    }

    private GPBeanDefinition doCreateBeanDefinition(String beanName, String registerClzName) {
        GPBeanDefinition beanDefinition = new GPBeanDefinition();
        beanDefinition.setBeanName(beanName);
        beanDefinition.setBeanClassName(registerClzName);
        return beanDefinition;
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

    private void doScan() {
        /**
         * 1.获取扫描包路径
         * 2.将包路径下面的类添加到classes
         */

        try {
            String scanPackage = this.appConfig.getProperty("scanPackage");
            loadClassNames(scanPackage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadClassNames(String scanPackage) throws Exception {
        String pkgPath = scanPackage.replaceAll("\\.", "/");
        URL url = this.getClass().getClassLoader().getResource(pkgPath);
        File pkgFile = new File(url.getPath());
        for (File f : pkgFile.listFiles()) {
            if (f.isFile()) {
                if (f.getName().endsWith(".class")) {
                    String clzName = scanPackage + "." + f.getName();
                    String clzRealName = clzName.replaceAll("\\.class", "");
                    Class clz = Class.forName(clzRealName);
                    //只有添加了注解GPController和注解GPService的类才添加到classes容器
                    if (clz.isAnnotationPresent(GPController.class) || clz.isAnnotationPresent(GPService.class)) {
                        scannedClassNames.add(clzRealName);
                    }
                }
            } else {
                //继续递归
                loadClassNames(scanPackage + "." + f.getName());
            }
        }
    }

    private void loadAppConfig() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(this.configLocations[0]);
            appConfig.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
