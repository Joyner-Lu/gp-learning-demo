package com.joyner.gp_learning.design_pattern.proxy.jdkproxy;

import com.joyner.gp_learning.design_pattern.proxy.static_proxy.DynamicDataSourceEntry;
import com.joyner.gp_learning.design_pattern.proxy.static_proxy.IOrderService;
import com.joyner.gp_learning.design_pattern.proxy.static_proxy.Order;
import com.joyner.gp_learning.design_pattern.proxy.static_proxy.OrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 使用动态代理改进
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
public class OrderServiceStaticProxy implements InvocationHandler {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class clz = target.getClass();
        Object r = Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), this);
        return r;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object r = method.invoke(target, args);
        after();
        return r;
    }



    private void before(Object target) throws Exception {

        System.out.println("proxy before process");
        Long time = (Long)target.getClass().getMethod("getCreateTime").invoke(target);
        int dbRouter = Integer.valueOf(simpleDateFormat.format(new Date(time)));
        System.out.println("静态代理分类到DB_" + dbRouter + "数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
    }

    private void after() {
        System.out.println("proxy after process");
    }

    public static void main(String[] args) throws Exception {
        Order order = new Order();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = simpleDateFormat.parse("2017-01-06").getTime();
        order.setCreateTime(time);
        order.setId("id_001");
        order.setOrderInfo("这是衣服订单");
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        IOrderService orderService = (IOrderService) orderServiceStaticProxy.getInstance(new OrderService());
        orderService.createOrder(order);
    }
}
