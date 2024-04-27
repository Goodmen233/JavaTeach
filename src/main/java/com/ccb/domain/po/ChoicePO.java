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
 * @Description: 选项表
 * @Author: CCB
 * @Date: 2023/2/14 10:08
 */
@Data
@ApiModel("选项信息")
@Table(name = "t_choice")
public class ChoicePO implements Serializable {

    private static final long serialVersionUID = 6744665788073684400L;

    /**
    * 选项id
    */
    @ApiModelProperty("选项id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
    * 序号
    */
    @ApiModelProperty("序号")
    private String no;
    /**
    * 内容
    */
    @ApiModelProperty("内容")
    private String content;
    /**
    * 关联题目id
    */
    @ApiModelProperty("关联题目id")
    private Long linkId;

}
