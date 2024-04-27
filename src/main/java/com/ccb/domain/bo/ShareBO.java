package com.ccb.domain.bo;

import com.ccb.domain.common.PageBO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 分享BO
 * @Author: CCB
 * @Date: 2023/4/3 18:24
 */
@Data
public class ShareBO extends PageBO {

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 标签集合
     */
    private List<Long> tagIdList;
}
