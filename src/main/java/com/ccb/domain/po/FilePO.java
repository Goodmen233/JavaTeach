package com.ccb.domain.po;

import com.ccb.common.enums.FileLinkTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 文件表
 * @Author: CCB
 * @Date: 2023/2/14 10:23
 */
@Data
@ApiModel("文件信息")
public class FilePO implements Serializable {

    private static final long serialVersionUID = 3827848778337873081L;

    /**
    * 文件id
    */
    @ApiModelProperty("文件id")
    private Long id;

    /**
    * 名称
    */
    @ApiModelProperty("名称")
    private String name;

    /**
    * 类型
    */
    @ApiModelProperty("类型")
    private String type;

    /**
    * 链接
    */
    @ApiModelProperty("链接")
    private String url;

    /**
    * 大小
    */
    @ApiModelProperty("大小")
    private Double size;

    /**
    * 关联id
    */
    @ApiModelProperty("关联id")
    private Long linkId;

    /**
    * 关联类型 0:人物头像 1:课程封面 2:章节内容 3:关联课程(资料)
    */
    @ApiModelProperty("关联类型: " + FileLinkTypeEnum.KEY_VALUE)
    private Integer linkType;

}
