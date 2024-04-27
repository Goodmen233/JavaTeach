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
 * @Description: 标签表
 * @Author: CCB
 * @Date: 2023/2/14 14:09
 */
@Data
@ApiModel("标签信息")
@Table(name = "t_tag")
public class TagPO implements Serializable {

    private static final long serialVersionUID = 2309001460041878342L;
    /**
    * 标签id
    */
    @ApiModelProperty("标签id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 名称
    */
    @ApiModelProperty("名称")
    private String name;

}
