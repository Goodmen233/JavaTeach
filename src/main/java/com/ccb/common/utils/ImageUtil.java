package com.ccb.common.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ImageUtil {

    /**
     * 图片路径层级分隔符
     */
    private static final String separator = "/";

    public static MultipartFile base64ToMultipartFile(String baseImg) {

        //定义一个正则表达式的筛选规则，为了获取图片的类型
        String rgex = "data:image/(.*?);base64";
        if (StrUtil.isBlank(baseImg)) {
            return null;
        }
        String type = getSubUtilSimple(baseImg, rgex);
        //去除base64图片的前缀
        baseImg = baseImg.replaceFirst("data:(.+?);base64,", "");
        byte[] imageByte;
        String fileName = "";
        //把图片转换成二进制
        imageByte = Base64.decode(baseImg.replaceAll(" ", "+"));

        //随机生成图片的名字，同时根据类型结尾
        fileName = UUID.randomUUID().toString() + "." + type;

        InputStream inputStream = new ByteArrayInputStream(imageByte);
        MockMultipartFile mockMultipartFile = null;
        try {
            mockMultipartFile = new MockMultipartFile(fileName, fileName, "", inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("转换图片失败");
        }
        return mockMultipartFile;
    }


    public static String getSubUtilSimple(String soap, String rgex) {
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            return m.group(1);
        }
        return "";
    }
}

