package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Description:
 *
 *   使用userMapper.java + userMapper.xml  + spring 整合的方式
 *
 * @Author: Mark
 * @Date: 2020/3/6 22:44
 */
public class UserMapperTest {

    @Test
    public void findUserById() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
//		UserMapper mapper = (UserMapper) ac.getBean("userMapper");
        User user = mapper.findUserById(10);
        System.out.println(user);
    }
}