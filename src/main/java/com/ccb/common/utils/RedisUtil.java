package com.ccb.common.utils;

import com.ccb.context.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;


/**
 * @Description: redis缓存工具类
 * @Author: CCB
 * @Date: 2023/2/10 11:03
 */
public class RedisUtil {
	
   private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

	private static final RedisTemplate<Serializable, Serializable> REDIS_TEMPLATE = SpringContextHolder.getBean("redisTemplate", RedisTemplate.class);
	
	/**
     * 前缀
     */
    public static final String KEY_PREFIX_VALUE = "JavaTeach:";

    /**
     * 缓存value操作
     * @param k key
     * @param v value
     * @param time 过期时间
     * @return 成功返回true，反之返回false
     */
    public static boolean cacheValue(String k, Serializable v, long time) {
        return cacheValue(k, v, time, TimeUnit.SECONDS);
    }

    /**
     * 缓存value操作
     *
     * @param k key
     * @param v value
     * @param time 时间
     * @param unit 时间单位
     * @return 成功返回true，反之返回false
     */
    public static boolean cacheValue(String k, Serializable v, long time, TimeUnit unit) {
        String key = KEY_PREFIX_VALUE + k;
        try {
            ValueOperations<Serializable, Serializable> valueOps = REDIS_TEMPLATE.opsForValue();
            valueOps.set(key, v);
            if (time > 0) {
                REDIS_TEMPLATE.expire(key, time, unit);
            }
            return true;
        } catch (Throwable t) {
            logger.error("缓存[{}]失败, value[{}]",key,v,t);
        }
        return false;
    }

    /**
     * 缓存value操作
     *
     * @param k key
     * @param v value
     * @return 成功返回true，反之返回false
     */
    public static boolean cacheValue(String k, Serializable v) {
        return cacheValue(k, v, -1);
    }

    /**
     * 判断缓存是否存在
     *
     * @param k key
     * @return 存在返回true，反之返回false
     */
    public static boolean containsValueKey(String k) {
        String key = KEY_PREFIX_VALUE + k;
        try {
            return Boolean.TRUE.equals(REDIS_TEMPLATE.hasKey(key));
        } catch (Throwable t) {
            logger.error("判断缓存存在失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

    /**
     * 获取缓存
     *
     * @param k key
     * @return 缓存值
     */
    public static Serializable getValue(String k) {
        try {
            ValueOperations<Serializable, Serializable> valueOps =  REDIS_TEMPLATE.opsForValue();
            return valueOps.get(KEY_PREFIX_VALUE + k);
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + KEY_PREFIX_VALUE + k + ", error[" + t + "]");
        }
        return null;
    }
    /**
     * 移除缓存
     *
     * @param k key
     * @return 移除成功返回true，反之返回false
     */
    public static boolean removeValue(String k) {
    	String key = KEY_PREFIX_VALUE + k;
    	try {
            REDIS_TEMPLATE.delete(key);
            return true;
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

    /**
     * 递增
     *
     * @param k key
     * @param delta 要增加几(大于0)
     * @return 结果值
     */
    public long incr(String k, long delta) {
        String key = KEY_PREFIX_VALUE + k;
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return REDIS_TEMPLATE.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param k key
     * @param delta 要减少几(小于0)
     * @return 结果值
     */
    public long decr(String k, long delta) {
        String key = KEY_PREFIX_VALUE + k;
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return REDIS_TEMPLATE.opsForValue().increment(key, -delta);
    }
}
