package com.ccb.service.impl;

import com.ccb.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * @Description: 邮箱服务实现
 * @Author: CCB
 * @Date: 2023/3/27 11:36
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendMail(String content, String to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject("JavaEDUP");
        mailMessage.setText(content);
        try {
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("发送简单邮件失败,内容：" + content);
        }
    }
}
