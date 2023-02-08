package com.ccb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description: 主程序入口
 * @Author: CCB
 * @Date: 2023/2/7 09:59
 */
@ServletComponentScan()
@SpringBootApplication
@MapperScan("com.ccb.mapper")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
