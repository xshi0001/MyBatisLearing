package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Mark
 * @Date: 2020/3/6 11:20
 */
public class OrderMapperTest {

    @Test
    public void selectOrderList() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        OrderMapper userMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = userMapper.selectOrderList();
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }
}