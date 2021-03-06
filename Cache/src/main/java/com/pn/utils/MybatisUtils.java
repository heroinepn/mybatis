package com.pn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
//使⽤Mybatis第⼀步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory，顾名思义，我们就可以从中获得SqlSession 的实例了。
    // SqlSession 完全包含了⾯向数据库执⾏ SQL 命令所需的所有⽅法。
    public static SqlSession getSqlSession(){
       // SqlSession sqlSession=sqlSessionFactory.openSession();
        //自动提交事务
        return sqlSessionFactory.openSession(true);
    }

}