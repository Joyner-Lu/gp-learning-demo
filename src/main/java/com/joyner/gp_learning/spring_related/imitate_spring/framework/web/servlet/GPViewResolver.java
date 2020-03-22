package com.joyner.gp_learning.spring_related.imitate_spring.framework.web.servlet;

import org.springframework.web.servlet.View;

import java.io.File;
import java.util.Locale;

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
public class GPViewResolver {

    private final static String DEFAULT_SUFFIX = ".html";

    private File templateRootDir;


    public GPViewResolver(String templateRoot) {
        String path = this.getClass().getResource("/" + templateRoot).getPath();
        templateRootDir = new File(path);
    }



    public GPView resolveViewName(String viewName, Locale locale){
        viewName = viewName.endsWith(DEFAULT_SUFFIX) ? viewName : viewName + DEFAULT_SUFFIX;
        String templatePath = templateRootDir.getPath() + "/" + viewName;
        templatePath = templatePath.replaceAll("/+", "/");

        File templateFile = new File(templatePath);
        GPView gpView = new GPView(templateFile);
        return gpView;
    }
}
