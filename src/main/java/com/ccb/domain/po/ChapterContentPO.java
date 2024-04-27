package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 章节内容表
 * @Author: CCB
 * @Date: 2023/2/14 10:05
 */
@Data
@ApiModel("章节内容信息")
@Table(name = "t_chapter_content")
public class ChapterContentPO implements Serializable {

    private static final long serialVersionUID = 7328899330712858398L;

    /**
    * 章节内容id
    */
    @ApiModelProperty("章节内容id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 内容
    */
    @ApiModelProperty("内容")
    private String content;

    /**
    * 关联章节id
    */
    @ApiModelProperty("关联章节id")
    private Long chapterId;

}
