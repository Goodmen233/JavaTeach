package com.ccb.controller;

import com.ccb.common.urls.student.StudentUrl;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.vo.req.student.ExerciseDetailReq;
import com.ccb.domain.vo.req.student.ExerciseSubmitReq;
import com.ccb.domain.vo.req.student.PersonalCenterModifyReq;
import com.ccb.domain.vo.req.student.PersonalCenterReq;
import com.ccb.domain.vo.resp.student.ExerciseDetailResp;
import com.ccb.domain.vo.resp.student.PersonalCenterResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 学生相关接口
 * @Author: CCB
 * @Date: 2023/2/9 17:43
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "学生相关接口")
public class StudentController {

    @ApiOperation("个人中心详情")
    @GetMapping(StudentUrl.PERSONAL_CENTER)
    @ResponseBody
    public ResultInfo<PersonalCenterResp> personalCenter(PersonalCenterReq personalCenterReq) {
        return ResultInfo.success();
    }

    @ApiOperation("个人中心修改")
    @PostMapping(StudentUrl.PERSONAL_CENTER_MODIFY)
    @ResponseBody
    public ResultInfo<Boolean> personalCenterModify(@RequestBody PersonalCenterModifyReq personalCenterModifyReq) {
        return ResultInfo.success();
    }

    @ApiOperation("作业/练习模块提交/修改")
    @PostMapping(StudentUrl.EXERCISE_SUBMIT)
    @ResponseBody
    public ResultInfo<Boolean> exerciseSubmit(@RequestBody ExerciseSubmitReq exerciseSubmitReq) {
        return ResultInfo.success();
    }

    @ApiOperation("作业/练习模块解答详情")
    @GetMapping(StudentUrl.EXERCISE_DETAIL)
    @ResponseBody
    public ResultInfo<ExerciseDetailResp> exerciseDetail(@RequestBody ExerciseDetailReq exerciseDetailReq) {
        return ResultInfo.success();
    }
}
