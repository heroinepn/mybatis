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

    public static SqlSession getSqlSession(){
        // SqlSession sqlSession=sqlSessionFactory.openSession();
        return sqlSessionFactory.openSession(true);
    }
    //增删改提交事务不用手动commit


}