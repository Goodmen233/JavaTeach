package com.ccb.domain.vo.resp.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description: 作业/练习列表出参
 * @Author: CCB
 * @Date: 2023/2/9 15:01
 */
@Data
@ApiModel("作业/练习列表出参")
public class ExerciseResp {

    /*
    id
    名称
    完成情况(学生：已完成未完成、老师：1/40完成人数)
    开始
    结束
     */
}
