package com.ccb.domain.po;

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
 * @Description: 讨论表
 * @Author: CCB
 * @Date: 2023/2/14 10:44
 */
@Data
@ApiModel("讨论信息")
@Table(name = "t_forum")
public class ForumPO implements Serializable {

    private static final long serialVersionUID = -1209598272149537591L;

    /**
    * 讨论id
    */
    @ApiModelProperty("讨论id")
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
    * 关联课程id
    */
    @ApiModelProperty("关联课程id")
    private Long courseId;

}
