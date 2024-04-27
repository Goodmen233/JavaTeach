package com.ccb.service;

/**
 * @Description: 邮箱服务
 * @Author: CCB
 * @Date: 2023/3/27 11:31
 */
public interface MailService {

    /**
     * 发送消息给指定用户
     *
     * @param content
     * @param to
     */
    void sendMail(String content, String to);
}
