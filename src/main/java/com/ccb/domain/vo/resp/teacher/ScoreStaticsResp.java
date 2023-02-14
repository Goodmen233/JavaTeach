package com.ccb.domain.vo.resp.teacher;

import com.ccb.domain.po.StudentScorePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 课程成绩统计出参
 * @Author: CCB
 * @Date: 2023/2/10 10:43
 */
@Data
@ApiModel("课程成绩统计出参")
public class ScoreStaticsResp {

    @ApiModelProperty("学生课程成绩")
    private List<StudentScorePO> studentScoreList;
}
