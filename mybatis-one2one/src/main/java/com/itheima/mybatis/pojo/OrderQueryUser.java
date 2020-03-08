package com.itheima.mybatis.pojo;

/**
 * @program: mybatis-sqlMapConfig
 * @description: 需求：查询所有订单信息，关联查询下单用户信息。
 * @author: JClearLove
 * @Date: 2020/03/06 15:25
 */
public class OrderQueryUser extends Order {


    /**
     * 一对一映射
     */
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderQueryUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}

