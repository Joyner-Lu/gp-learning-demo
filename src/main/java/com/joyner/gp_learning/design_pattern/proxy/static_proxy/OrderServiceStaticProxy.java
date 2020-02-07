package com.joyner.gp_learning.design_pattern.proxy.static_proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        long time = order.getCreateTime();
        int dbRouter = Integer.valueOf(simpleDateFormat.format(new Date(time)));
        System.out.println("静态代理分类到DB_" + dbRouter + "数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before() {
        System.out.println("proxy before process");
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
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy(new OrderService());
        orderServiceStaticProxy.createOrder(order);
    }
}
