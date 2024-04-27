package com.ccb.domain.bo;

import com.ccb.domain.common.PageBO;
import lombok.Data;

/**
 * @Description: 查询作业/练习信息
 * @Author: CCB
 * @Date: 2023/3/27 18:32
 */
@Data
public class ExerciseQueryBO extends PageBO {

    /**
     * 课程id
     */
    private Long courseId;
}
