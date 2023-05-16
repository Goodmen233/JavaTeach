package com.ccb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

/**
 * @Description: CK编辑器文件配置
 * @Author: CCB
 * @Date: 2023/5/16 19:48
 */
@Configuration
public class CkEditorConfig {

    /**
     * 配置文件接收Resolver
     *
     * @return
     * @throws IOException
     */
    @Bean
    public MultipartResolver fuck() throws IOException {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setUploadTempDir(new FileSystemResource("temp/"));
        return commonsMultipartResolver;
    }
}
