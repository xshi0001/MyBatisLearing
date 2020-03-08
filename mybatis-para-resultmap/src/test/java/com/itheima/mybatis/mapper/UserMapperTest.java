package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description: 测试 mapper
 * @Author: Mark
 * @Date: 2020/3/5 21:35
 */
public class UserMapperTest {

    @Test
    public void findUserById() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(10);
        System.out.println(user);
    }


    @Test
    public void findUserByQueryVo() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("五");
        queryVo.setUser(user);

        List<User> userByQueryVo = userMapper.findUserByQueryVo(queryVo);
        for (User item : userByQueryVo) {
            System.out.println(item.toString());
        }

    }


    @Test
    public void findUserBySexAndUserName() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setSex("1");
        user.setUsername("陈小明");
        List<User> userBySexAndUserName = userMapper.findUserBySexAndUserName(user);
        for (User userItem : userBySexAndUserName) {
            System.out.println(userItem.toString());
        }
    }

    @Test
    public void findUserByIds() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(22);
        ids.add(24);
        ids.add(25);
        QueryVo queryVo = new QueryVo();
        queryVo.setIds(ids);
        List<User> userByIds = userMapper.findUserByIds(queryVo);
        for (User userById : userByIds) {
            System.out.println(userById.toString());
        }
    }


    @Test
    public void findUserByIdsUseList() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(22);
        ids.add(24);
        ids.add(25);

        List<User> userByIds = userMapper.findUserByIdsUseList(ids);
        for (User userById : userByIds) {
            System.out.println(userById.toString());
        }
    }

    @Test
    public void findUserByIdsUseArray() throws IOException {

        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer[] ids = new Integer[3];
        ids[0] = 22;
        ids[1] = 24;
        ids[2] = 25;


        List<User> userByIds = userMapper.findUserByIdsUseArray(ids);
        for (User userById : userByIds) {
            System.out.println(userById.toString());
        }
    }


}