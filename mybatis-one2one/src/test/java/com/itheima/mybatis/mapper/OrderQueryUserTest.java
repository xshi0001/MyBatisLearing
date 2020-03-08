package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.Order;
import com.itheima.mybatis.pojo.OrderQueryUser;
import com.itheima.mybatis.pojo.User;
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
 * @Date: 2020/3/6 16:01
 */
public class OrderQueryUserTest {

    @Test
    public void findOrderUserInfo() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        OrderMapper orderQueryUser = sqlSession.getMapper(OrderMapper.class);
        List<OrderQueryUser> orderUserInfo = orderQueryUser.findOrderUserInfo();
        for (OrderQueryUser queryUser : orderUserInfo) {
            System.out.println(queryUser.toString());
        }

    }
}