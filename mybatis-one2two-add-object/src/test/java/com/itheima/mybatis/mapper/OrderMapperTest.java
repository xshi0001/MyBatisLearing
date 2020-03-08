package com.itheima.mybatis.mapper;

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
 * @Date: 2020/3/6 18:58
 */
public class OrderMapperTest {

    @Test
    public void selectUserList() throws IOException {
          //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<User> users = mapper.selectUserList();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}