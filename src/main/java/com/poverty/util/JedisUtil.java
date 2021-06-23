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

    public static Object get(String key) {
        return jedisPool.getResource().get(key);
    }

    public static boolean set(String key, String value,long time) {
        Jedis jedis = getJedis();

        if (jedis != null) {
            jedis.set(key, value);
            jedis.expire(key, time);
            jedis.close();
            return true;
        } else {
            return false;
        }
    }

    public static boolean delete(String key) {
        Jedis jedis = getJedis();
        if (jedis != null && jedis.del(key) > 0) {
            jedis.close();
            return true;
        }
        return false;
    }

    public static boolean refresh(String key,long time) {
        Jedis jedis = getJedis();
        if (jedis != null && jedis.exists(key)) {
            jedis.expire(key, time);
            jedis.close();
            return true;
        } else {
            return false;
        }
    }

    public static boolean exists(String key) {
        Jedis jedis = getJedis();
        if (jedis != null && jedis.exists(key)) {
            jedis.close();
            return true;
        } else {
            return false;
        }
    }
}