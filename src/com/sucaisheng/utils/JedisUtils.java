package com.sucaisheng.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis工具类
 *  获取Jedis连接
 *  获取Jedis连接池
 *  关闭连接
 */
public class JedisUtils {
    //连接池对象
    private static JedisPool jedisPool;

    static{
        //获取资源加载流
        InputStream resourceAsStream = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建properties
        Properties properties = new Properties();
        try {
            //关联数据流
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置config配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        //初始化JedisPool
        jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }

    /**
     * 获取jedis连接对象
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 获取Jedis连接池
     * @return
     */
    public static JedisPool getJedisPool(){
        return jedisPool;
    }

    /**
     * 关闭连接
     * @param jedis
     */
    public static void close(Jedis jedis){
        jedis.close();
    }
}
