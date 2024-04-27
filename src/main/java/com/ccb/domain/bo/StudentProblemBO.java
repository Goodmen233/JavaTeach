package com.ccb.domain.bo;

import lombok.Data;

import java.util.List;

/**
 * @Description: 学生题目BO
 * @Author: CCB
 * @Date: 2023/4/6 14:20
 */
@Data
public class StudentProblemBO {

    /**
     * 学生答题id
     */
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 题目id
     */
    private Long problemId;

    /**
     * 题目id集合
     */
    private List<Long> problemIdList;

}
