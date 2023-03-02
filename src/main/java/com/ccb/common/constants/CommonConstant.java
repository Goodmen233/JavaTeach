package com.ccb.common.constants;

/**
 * @Description: 通用常量
 * @Author: CCB
 * @Date: 2023/3/2 17:23
 */
public interface CommonConstant {

    /**
     * token生成的加密key
     */
    String ENCRYPT_KEY = "ccbhqunb";

    /**
     * redis默认的过期时间
     */
    Integer REDIS_EXPIRED_TIME = 60 * 60;

}
