package com.itheima.mybatis.pojo;

/**
 * @program: mybatis-sqlMapConfig
 * @description: 需求：查询所有用户信息及用户关联的订单信息。
 * <p>
 * 用户信息和订单信息为一对多关系。
 * @author: JClearLove
 * @Date: 2020/03/06 17:31
 */
public class UserQueryQrder extends User {

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "UserQueryQrder{" +
                "order=" + order +
                "} " + super.toString();
    }
}

