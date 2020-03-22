package com.joyner.gp_learning.spring_related.imitate_spring.framework.web.servlet;

import lombok.Data;

import java.util.Map;

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
public class GPModelAndView {

    /** View instance or view name String */
    //spring原生使用的时候Object，这里为了方便我们直接使用String
    private String view;

    /** Model Map */
    private Map<String,Object> model;

    public GPModelAndView() {

    }

    public GPModelAndView( String view) {
        this.view = view;
    }

    public GPModelAndView( String view, Map<String,Object> model) {
        this.view = view;
        this.model = model;
    }
}
