package com.sucaisheng.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC的工具类：
 *  实现获取连接，关闭资源
 *
 *  1、使用静态代码块获取到资源文件里面的URL、username、password、driver
 *      获取classLoader，通过其获取到properties里面的资源
 *   2、创建获取连接的方法
 *   3、创建关闭资源的方法
 */
public class JDBCUtils {
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static String driver = null;
    //1、使用静态代码块获取到资源文件里面的URL、username、password、driver
    static {
        Properties pro = new Properties();
        //获取classLoader，通过其获取到properties里面的资源
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        //获取到properties文件的路径
        URL resource = classLoader.getResource("jdbc.properties");
        String path = resource.getPath();
        try {
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2、创建获取连接的方法
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    //3、创建关闭资源的方法
    public static void close(ResultSet res, Statement sta, Connection con){
        if (res != null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Statement sta, Connection con){
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
