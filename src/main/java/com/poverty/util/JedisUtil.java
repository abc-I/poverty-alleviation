package com.poverty.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/17 13:08
 */
@Component
public class JedisUtil {
    private static JedisPool jedisPool;

    @Autowired
    public void setJedisPool(JedisPool jedisPool) {
        JedisUtil.jedisPool = jedisPool;
    }

    public static Jedis getJedis() {
        if (jedisPool != null) {
            return jedisPool.getResource();
        } else {
            return null;
        }
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return Object
     */
    public static Object get(String key) {
        return jedisPool.getResource().get(key);
    }

    /**
     * 保存键值对
     *
     * @param key 键
     * @param value 值
     * @param time 有效时间
     * @return boolean
     */
    public static boolean set(String key, String value,long time) {
        // 获取jedis
        Jedis jedis = getJedis();

        if (jedis != null) {
            // 保存键值对
            jedis.set(key, value);
            // 保存有效时间
            jedis.expire(key, time);
            // 返还连接
            jedis.close();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除键值对
     *
     * @param key 键
     * @return boolean
     */
    public static boolean delete(String key) {
        // 获取jedis
        Jedis jedis = getJedis();
        // 删除key
        if (jedis != null && jedis.del(key) > 0) {
            jedis.close();
            return true;
        }
        return false;
    }

    /**
     * 刷新键值对有效期
     *
     * @param key 键
     * @param time 有效时间
     * @return boolean
     */
    public static boolean refresh(String key,long time) {
        Jedis jedis = getJedis();
        if (jedis != null && jedis.exists(key)) {
            // 更新有效期
            jedis.expire(key, time);
            jedis.close();
            return true;
        } else {
            return false;
        }
    }
}