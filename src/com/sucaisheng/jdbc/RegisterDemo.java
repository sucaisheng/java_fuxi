package com.sucaisheng.jdbc;

import com.sucaisheng.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public interface RegisterDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        Boolean register = RegisterDemo.register(username, password);
        if (register){
            System.out.println("登陆成功！");
        } else{
            System.out.println("用户名或者密码错误！");
        }
    }

    public static Boolean register(String username, String password){
        Connection con = null;
        Statement statement = null;
        boolean b = false;
        try {
            con = JDBCUtils.getConnection();
            statement = con.createStatement();
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            b = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,con);
        }
        return b;
    }
}
