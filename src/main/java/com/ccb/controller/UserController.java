package com.ccb.controller;

import com.ccb.common.urls.UserUrl;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.vo.req.user.*;
import com.ccb.domain.vo.resp.user.*;
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
 * @Description: 登录接口
 * @Author: CCB
 * @Date: 2023/2/8 16:14
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "用户通用接口")
public class UserController {

    @ApiOperation("登录")
    @PostMapping(UserUrl.LOGIN)
    @ResponseBody
    public ResultInfo<LoginResp> login(@RequestBody LoginReq loginReq) {
        return ResultInfo.success();
    }

    @ApiOperation("注册信息详情")
    @PostMapping(UserUrl.REGISTER)
    @ResponseBody
    public ResultInfo<RegisterResp> register(@RequestBody RegisterReq registerReq) {
        // 只注册学生和老师共用的属性(班级信息只有学生才有)
        return ResultInfo.success();
    }

    @ApiOperation("注册信息提交")
    @PostMapping(UserUrl.REGISTER_SUBMIT)
    @ResponseBody
    public ResultInfo<Boolean> registerSubmit(@RequestBody RegisterSubmitReq registerSubmitReq) {
        // 学生注册需要关联班级,教师不用(在注册后登录在个人中心创建班级供学生选择)
        return ResultInfo.success();
    }

    @ApiOperation("修改密码")
    @PostMapping(UserUrl.UPDATE_PASSWORD)
    @ResponseBody
    public ResultInfo<Boolean> updatePassword(@RequestBody UpdatePasswordReq updatePasswordReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程列表信息")
    @GetMapping(UserUrl.COURSE)
    @ResponseBody
    public ResultInfo<CourseResp> course(CourseReq courseReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程章节树信息")
    @GetMapping(UserUrl.CHAPTER_TREE)
    @ResponseBody
    public ResultInfo<ChapterTreeResp> chapterTree(ChapterTreeReq chapterTreeReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程章节内容")
    @GetMapping(UserUrl.CHAPTER_CONTENT)
    @ResponseBody
    public ResultInfo<ChapterContentResp> chapterContent(ChapterContentReq chapterContentReq) {
        return ResultInfo.success();
    }

    @ApiOperation("作业/练习信息")
    @GetMapping(UserUrl.EXERCISE)
    @ResponseBody
    public ResultInfo<ExerciseResp> exercise(ExerciseReq exerciseReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程资料")
    @GetMapping(UserUrl.RESOURCE)
    @ResponseBody
    public ResultInfo<ResourceResp> resource(ResourceReq resourceReq) {
        return ResultInfo.success();
    }

    @ApiOperation("交流详情")
    @GetMapping(UserUrl.COMMUNICATION)
    @ResponseBody
    public ResultInfo<CommunicationResp> communication(CommunicationReq communicationReq) {
        return ResultInfo.success();
    }

    @ApiOperation("发布交流")
    @PostMapping(UserUrl.COMMUNICATION_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> communicationPublish(@RequestBody CommunicationPublishReq communicationPublishReq) {
        return ResultInfo.success();
    }

    @ApiOperation("删除交流")
    @PostMapping(UserUrl.COMMUNICATION_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> communicationDelete(@RequestBody CommunicationDeleteReq communicationDeleteReq) {
        return ResultInfo.success();
    }
}
