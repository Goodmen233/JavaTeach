package com.ccb.aspect;

import com.alibaba.fastjson.JSON;
import com.ccb.common.annotations.MethodLog;
import com.ccb.common.enums.BooleanEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 方法切面，打印出入参，异常处理
 * @Author: CCB
 * @Date: 2023/2/10 11:15
 */
@Aspect
@Component
@Slf4j
public class MethodAspect {

    /**
     * 执行方法前执行日志记录
     *
     * @param joinPoint 切入点
     */
    @Before("@annotation(methodLog)")
    public void doBefore(JoinPoint joinPoint, MethodLog methodLog) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        try {
            Object[] args = joinPoint.getArgs();
            //IP地址
            String methodName = method.getName();
            Map<String, Object> map = new HashMap<>(8);
            DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
            String[] parameterNames = discoverer.getParameterNames(method);
            if (Objects.isNull(parameterNames)) {
                if(Objects.equals(methodLog.logReq(), BooleanEnum.YES.getIndex())) {
                    log.info("【请求开始】请求方法名=【{}】, 请求参数为空", methodName);
                }
            } else {
                for (int i = 0; i < parameterNames.length; i++) {
                    map.put(parameterNames[i], args[i]);
                }
                if(Objects.equals(methodLog.logReq(), BooleanEnum.YES.getIndex())) {
                    log.info("【请求开始】请求方法名=【{}】, 请求参数=【{}】", methodName, JSON.toJSONString(map));
                }
            }
        } catch (Exception e) {
            log.error("【请求结束】请求失败，方法名=【{}】", method.getName());
        }
    }

    /**
     * 执行方法后执行日志记录
     *
     * @param joinPoint 切入点
     * @param returnVal 返回值
     */
    @AfterReturning(pointcut = "@annotation(methodLog)", returning = "returnVal")
    public void doReturning(JoinPoint joinPoint, Object returnVal, MethodLog methodLog) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        try {
            String methodName = method.getName();
            if(Objects.equals(methodLog.logResp(), BooleanEnum.YES.getIndex())) {
                log.info("【请求结束】请求方法名=【{}】,响应结果=【{}】", methodName, JSON.toJSONString(returnVal));
            }
        } catch (Exception e) {
            log.error("【请求失败】请求方法名=【{}】", method.getName());
        } catch (Throwable throwable) {
            log.error("【解析结果失败】方法名=【{}】", method.getName());
        }
    }

    /**
     * 执行方法抛异常的日志
     *
     * @param joinPoint 切入点
     * @param ex 异常
     * @param methodLog 注解
     */
    @AfterThrowing(pointcut = "@annotation(methodLog)", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Throwable ex, MethodLog methodLog) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        try {
            String methodName = method.getName();
            log.info("【{}】方法抛出异常", methodName, ex);
        } catch (Exception e) {
            log.error("记录日志失败！{}", method.getName());
        }
    }

}
