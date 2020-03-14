package com.joyner.gp_learning.spring_related.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

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
@Controller
@RequestMapping("/userController")
public class UserController {

    @RequestMapping("doAdd")
    @ResponseBody
    public String doAdd(HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("add user");
        return "success";
    }

}
