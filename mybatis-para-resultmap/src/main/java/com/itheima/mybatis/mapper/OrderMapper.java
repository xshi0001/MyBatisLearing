package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.Order;

import java.util.List;

/**
 * @program: mybatis-sqlMapConfig
 * @description: Order表的Dao
 * @author: JClearLove
 * @Date: 2020/03/06 11:07
 */
public interface OrderMapper {


    List<Order> selectOrderList();

}
