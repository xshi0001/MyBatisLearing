package com.itheima.mybatis.dao.imp;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;


/**
 * @Description:
 * @Author: Mark
 * @Date: 2020/3/5 21:39
 */
public class UserDaoImplTest {

    public SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void testDao() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        User user = userDao.selectUserById(10);
        System.out.println(user);
    }
}