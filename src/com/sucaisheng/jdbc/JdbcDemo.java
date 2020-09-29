package com.sucaisheng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 添加依赖
 * 1、注册jdbc链接
 * 2、获取jdbc链接
 * 3、获取statement
 * 4、创建sql语句
 * 5、执行SQL语句
 * 6、关闭资源
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //1、注册jdbc链接
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、获取jdbc链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT", "root", "15186478704scs?");
        // 3、获取statement
        Statement statement = connection.createStatement();
        //4、创建sql语句
        String sql = "insert into student values(null,'张三',18)";
        int i = statement.executeUpdate(sql);
        System.out.println(i);
    }
}
