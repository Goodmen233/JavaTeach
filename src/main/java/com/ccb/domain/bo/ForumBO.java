package com.ccb.domain.bo;

import com.ccb.domain.common.PageBO;
import lombok.Data;

/**
 * @Description: 讨论BO
 * @Author: CCB
 * @Date: 2023/3/29 14:06
 */
@Data
public class ForumBO extends PageBO {

    /**
     * 课程id
     */
    private Long courseId;
}
