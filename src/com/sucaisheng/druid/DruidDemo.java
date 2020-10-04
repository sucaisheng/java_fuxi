package com.sucaisheng.druid;

import com.sucaisheng.utils.DRUIDUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * druid工具类测试
 *  1、获取到连接对象
 *  1、获取到连接对象
 *  3、将连接对象放回数据连接池
 *  4、获取连接池
 *  5、释放资源
 */
public class DruidDemo {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement sta = null;

        try {
            //1、获取到连接对象
            conn = DRUIDUtils.getConnection();

            //1、获取到连接对象
            String sql = "insert into student values(null,?,?)";
            sta = conn.prepareStatement(sql);
            sta.setString(1,"李四");
            sta.setInt(2,19);
            int i = sta.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //3、将连接对象放回数据连接池
            DRUIDUtils.close(sta,conn);
        }

        //4、获取连接池
        DataSource dataSource = DRUIDUtils.getDataSource();
        for (int i = 0; i < 10; i++) {
            try {
                conn = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(i + ":" + conn);
        }
    }
}
