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
 * @Description: 学生答题表
 * @Author: CCB
 * @Date: 2023/2/14 13:29
 */
@Data
@ApiModel("学生答题信息")
@Table(name = "t_student_problem")
public class StudentProblemPO implements Serializable {

    private static final long serialVersionUID = -7319467556133384281L;

    /**
    * 学生答题id
    */
    @ApiModelProperty("学生答题id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 学生id
    */
    @ApiModelProperty("学生id")
    private Long studentId;

    /**
    * 题目id
    */
    @ApiModelProperty("题目id")
    private Long problemId;

    /**
    * 学生答题结果
    */
    @ApiModelProperty("学生答题结果")
    private String answer;

}
