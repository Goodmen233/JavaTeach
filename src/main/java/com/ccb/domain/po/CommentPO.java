package com.ccb.domain.po;

import com.ccb.common.enums.CommentLinkTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 评论表
 * @Author: CCB
 * @Date: 2023/2/14 10:11
 */
@Data
@ApiModel("评论信息")
@Table(name = "t_comment")
public class CommentPO implements Serializable {

    private static final long serialVersionUID = 427802600685421038L;

    /**
    * 评论id
    */
    @ApiModelProperty("评论id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
    * 内容
    */
    @ApiModelProperty("内容")
    private String content;
    /**
    * 发布时间
    */
    @ApiModelProperty("发布时间")
    private Date publishDatetime;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Long userId;
    /**
    * 用户头像
    */
    @ApiModelProperty("用户头像")
    private String userAvatar;
    /**
    * 用户名称
    */
    @ApiModelProperty("用户名称")
    private String userName;
    /**
    * 关联id
    */
    @ApiModelProperty("关联id")
    private Long linkId;

    /**
    * 关联类型 0:讨论 1:分享 2:评论
    */
    @ApiModelProperty("关联类型: " + CommentLinkTypeEnum.KEY_VALUE)
    private Integer linkType;


}
