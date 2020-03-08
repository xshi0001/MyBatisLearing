package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 *
 *    传统dao测试 + spring整合
 * @Author: Mark
 * @Date: 2020/3/6 23:27
 */
public class UserDaoImplTest {
    private ApplicationContext context;


    @Before
    public void setUp() throws Exception {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void queryUserById() {
        // 获取userDao
        UserDao userDao = this.context.getBean(UserDao.class);
        User user = userDao.queryUserById(1);
        System.out.println(user);
    }

    @Test
    public void queryUserByUsername() {
        // 获取userDao
        UserDao userDao = this.context.getBean(UserDao.class);

        List<User> list = userDao.queryUserByUsername("张");
        for (User user : list) {
            System.out.println(user);
        }

    }

    @Test
    public void saveUser() {
// 获取userDao
        UserDao userDao = this.context.getBean(UserDao.class);

        User user = new User();
        user.setUsername("曹操");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("三国");
        userDao.saveUser(user);
        System.out.println(user);
    }


}
