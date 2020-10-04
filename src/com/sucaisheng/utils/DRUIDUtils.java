package com.sucaisheng.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 阿里数据连接池工具类：
 *   1、读取配置文件
 *   2、获取到数据连接池对象
 *   3、创建获取连接方法
 *   4、创建获取连接池方法
 *   5、释放资源方法
 */
public class DRUIDUtils {
    private static DataSource ds;
    static {
        //1、读取配置文件
        Properties pro = new Properties();
        try {
            pro.load(DRUIDUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2、获取到数据连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3、创建获取连接方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //4、创建获取连接池方法
    public static DataSource getDataSource(){
        return ds;
    }

    //5、释放资源方法
    public static void close(ResultSet rs, Statement sta, Connection conn){
        if (rs != null){
            try {
                rs.close();
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

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement sta, Connection conn){
        close(null,sta,conn);
    }
}
