package com.ccb.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 登录用户信息
 * @Author: CCB
 * @Date: 2023/3/2 16:27
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2105121175679823476L;

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像id
     */
    private Long avatarId;

    /**
     * 头像链接
     */
    private String avatarUrl;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 班级id
     */
    private Long classId;
}
