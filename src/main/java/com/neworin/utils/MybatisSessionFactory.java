package com.neworin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
 * Session工厂类
 * 实现获取、释放mybatis与数据库连接的工具类
 * Created by NewOrin Zhang on 2016/6/29.
 * Email: NewOrinZhang@Gmail.com
 */
public class MybatisSessionFactory {
    //mybatis配置文件
    private static final String CONFIG_FILE_LOCATION = "config.xml";
    // 封装线程池，让每个线程从线程池中获取1个连接，让1个线程对应一条数据库连接 -- ThreadLocal
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    // 用于读取配置文件的IO流对象
    private static InputStream is;
    // 用于管理多个连接的工厂对象
    private static SqlSessionFactory fac;

    static {
        try {
            is = Resources.getResourceAsStream(CONFIG_FILE_LOCATION);//读取配置文件
            fac = new SqlSessionFactoryBuilder().build(is);//创建工厂
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接的方法
     *
     * @return
     */
    public static SqlSession getSession() {
        //从线程池中获取一条连接
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = fac.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() {
        // 获取当前连接
        SqlSession session = threadLocal.get();
        // 将连接从线程池中清除
        threadLocal.set(null);
        if (session != null) {
            session.close();// 物理关闭
        }
    }
}
