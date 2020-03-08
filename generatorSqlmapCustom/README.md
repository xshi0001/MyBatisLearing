# Mybatis 逆向工程

> Mapper使用官方网站的Mapper自动生成工具mybatis-generator-core-1.3.2来  
> 生成po类和Mapper.xml映射文件。Mybatis需要编写sql语句，mybatis官方提供  
> 逆向工程，可以针对单表自动生成Mybatis执行所需要的代码（mapper.java、  
> mapper.xml、pojo…），提高工作效率(比如100张表，避免手动生成100个pojo;再如针对一个单表进行crud操作时候，需要频繁的新建接口方法，再配置)。


## Table of contents

* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info

本项目意义在于演示如何使用generatorConfig.xml文件快速构建mapper层和pojo层，并与spring结合在一起，通过对单表order的表  
测试基于criteria的条件crud操作。

## Screenshots
![image](img/image.png)

## Technologies

* **MyBatis** - version 3.2.3
* **MyBatis-generator-core** - version 1.3.2
* **spring** - version 4.1.3
* **Eclipse**
* **Maven**
* **JDK8**


## Project architecture




## Directory Structure

开始执行 [GeneratorSqlmap.java](src/main/java/GeneratorSqlmap.java#L9-L35) 之前，目录结构为：此时包mapper/pojo没有文件，
```
src                                              
├─main                                           
│  ├─java                                        
│  │  │  GeneratorSqlmap.java                    
│  │  │                                          
│  │  └─com                                      
│  │      └─itheima                              
│  │          └─mybatis                          
│  │              ├─mapper                             
│  │              │                              
│  │              └─pojo                           
│  └─resources                                                                          
│          generatorConfig.xml                   
│          log4j.properties                                                                                                                                  
```

## Setup

1. 首先，新建maven工程，同时新建generatorConfig.xml（idea右击项目名称可以新建），并根据数据库定制自己的配置文件，定制内容主要包括
    数据库环境、持久化对象pojo、配置mapper.xml映射文件、配置mapper接口以及表转换内容；
2. 其次，编写[GeneratorSqlmap.java](src/main/java/GeneratorSqlmap.java#L9-L35) 生成代码，一些配置项，最后运行
3. 检查是否在包pojo/mapper生成自己配置的内容
4. 配置MyBatis的配置文件~~sqlMapConfig.xml~~，别名、扫描mapper.xml配置等操作 （非必要，**可以在spring配置文件applicationContext.xml，在sqlSessionFactoryBean中选择添加pojo包别名
   org.mybatis.spring.SqlSessionFactoryBean.setTypeAliasesPackage**）

5. 配置spring 依赖、配置文件applicationContext.xml文件 + db.properties ,注入数据库资源、基于xml映射的Mapper层动态代理开发注入生成的sqlSessionFactoryBean。并且扫描mapper对象操作
6. 编写测试类 [OrdersMapperTest.java](src/test/java/com/itheima/mybatis/mapper/OrdersMapperTest.java#L12)


此时目录结构变化为：
```
src.
├─main
│  ├─java
│  │  │  GeneratorSqlmap.java
│  │  └─com
│  │      └─itheima
│  │          └─mybatis
│  │              ├─mapper
│  │              │      OrdersMapper.java       # 以下是新生产的mapper层文件
│  │              │      OrdersMapper.xml        
│  │              │      UserMapper.java
│  │              │      UserMapper.xml
│  │              │
│  │              └─pojo                                 
│  │                      Orders.java                 #以下是持久层对象
│  │                      OrdersExample.java
│  │                      User.java
│  │                      UserExample.java
│  │
│  └─resources
│          applicationContext.xml              #spring 配置文件
│          db.properties                       #mysql 数据库配置文件
│          generatorConfig.xml                 # 生产mapper、pojo的配置文件
│          log4j.properties                    #日志文件
│          sqlMapConfig.xml                   # mybatis配置文件
└─test
    .....
    └─ OrdersMapperTest.java             # 对orders 包进行测试
```

## Code Examples


## Features

List of features ready and TODOs for future development
*  generatorConfig.xml配置参数一知半解，基本满足简单单表生产，但是一些坑还没有出现，能力比较弱
*  配置过程比较繁琐
*  本文是采用Esclipe + Maven 编程环境，因此在读取resource目录下有差别


To-do list:
* 目前没有对generatorConfig.xml配置中参数进行详细研究，这个等具体的项目需要进行深入理解
* spring将mappper层的对象注入bean的过程实在是繁琐，虽然有利于mybatis-spring包源码理解，期待后面springboot整合MyBatis，使用注解的方式完成。

## Status

   本项目还在更新中，因为对于MyBatis逆向工程的技术细节还没有深挖，后面期待mybatis-spring-1.2.2包源码更多技术细节解读

## Inspiration

.

## Contact

Created by [@JClearLove](https://www.flynerd.pl/) - feel free to contact me!


