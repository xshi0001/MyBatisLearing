package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.OrdersExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/07 11:21
 */
public class OrdersMapperTest {


    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }


    /**
     * 测试订单中, 用户id=1的订单数量
     */
    @Test
    public void countByExample() {
        // 获取Mapper
        OrdersMapper ordersMapper = this.context.getBean(OrdersMapper.class);
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andUserIdEqualTo(1);
        int i = ordersMapper.countByExample(ordersExample);
        System.out.println(i);

    }

    /**
     * 测试订单中，查询订单id (3,4)的订单详细
     */
    @Test
    public void selectByExample() {
        // 获取Mapper
        OrdersMapper ordersMapper = this.context.getBean(OrdersMapper.class);
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andIdBetween(3, 4);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);

        for (Orders order : orders) {
            System.out.println(order.toString());
        }


    }

    /**
     * 测试订单中，更新操作
     * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
     * 更新用户id 等于10的number值
     */
    @Test
    public void updateByExampleSelective() {
        // 获取Mapper
        OrdersMapper ordersMapper = this.context.getBean(OrdersMapper.class);
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andUserIdEqualTo(10);
        // 更新的字段
        Orders orders = new Orders();
        orders.setNote("updateByExampleSelective");
        int i = ordersMapper.updateByExampleSelective(orders, ordersExample);
        System.out.println(i);


    }

    @Test
    public void updateByPrimaryKeySelective() {
    }
}