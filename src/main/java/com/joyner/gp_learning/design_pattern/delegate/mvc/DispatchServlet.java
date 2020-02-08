package com.joyner.gp_learning.design_pattern.delegate.mvc;

import com.joyner.gp_learning.design_pattern.delegate.mvc.controllers.MemberController;
import com.joyner.gp_learning.design_pattern.delegate.mvc.controllers.OrderController;
import com.joyner.gp_learning.design_pattern.delegate.mvc.controllers.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
public class DispatchServlet extends HttpServlet {

    private List<Handler> handlerMappings = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        try {
            Class clz = MemberController.class;
            Method method = clz.getMethod("getMemberById", new Class[]{String.class});
            Object controller = clz.newInstance();
            handlerMappings.add(new Handler(controller, method, "/getMemberById.do"));

            clz =  OrderController.class;
            method = clz.getMethod("getOrderById", new Class[]{String.class});
            controller = clz.newInstance();
            handlerMappings.add(new Handler(controller, method, "/getOrderById.do"));

            clz =  SystemController.class;
            method = clz.getMethod("logout", new Class[]{});
            controller = clz.newInstance();
            handlerMappings.add(new Handler(controller, method, "/logout.do"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");
        Handler handler = null;
        for (Handler h : handlerMappings) {
            if (uri.equals(h.getUri())) {
                handler = h;
                break;
            }
        }
        try {
            handler.getMethod().invoke(handler.getController(), mid);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       /* if ("/getMemberById.do".equals(uri)) {
            new MemberController().getMemberById(mid);
        } else if("/getOrderById.do".equals(uri)) {
            new OrderController().getOrderById(mid);
        } else if ("/logout.do".equals(uri)) {
            new SystemController().logout();
        } else {
            resp.getWriter().write("404 Not Found.");
        }*/

    }

    class Handler {
        private Object controller;
        private Method method;
        private String uri;

        public Handler(Object controller, Method method, String uri) {
            this.controller = controller;
            this.method = method;
            this.uri = uri;
        }

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUri() {
            return uri;
        }

        public Handler setUri(String uri) {
            this.uri = uri;
            return this;
        }
    }
}
