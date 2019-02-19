package com.yin.utils;


import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {
    public static SqlSession getSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();

        return sqlSession;
    }
}
