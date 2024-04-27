package com.ccb.common.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description: 方法切面，打印入参出参
 * @Author: CCB
 * @Date: 2023/2/10 11:15
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodLog {

    int logReq() default 0;

    int logResp() default 1;

}
