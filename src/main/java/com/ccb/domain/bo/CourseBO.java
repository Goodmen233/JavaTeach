package com.ccb.domain.bo;

import com.ccb.domain.common.PageBO;
import lombok.Data;

/**
 * @Description: 课程BO
 * @Author: CCB
 * @Date: 2023/3/27 15:24
 */
@Data
public class CourseBO extends PageBO {

    /**
     * 课程id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 教师id
     */
    private Long teacherId;
}
