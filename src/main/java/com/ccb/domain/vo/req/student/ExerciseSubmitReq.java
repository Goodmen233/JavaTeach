package com.ccb.domain.vo.req.student;

import com.ccb.domain.po.StudentProblemPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 作业/练习模块提交入参
 * @Author: CCB
 * @Date: 2023/2/9 17:56
 */
@Data
@ApiModel("作业/练习模块提交入参")
public class ExerciseSubmitReq {

    @ApiModelProperty("作业/练习学生答题记录集合")
    private List<StudentProblemPO> answerList;
}
