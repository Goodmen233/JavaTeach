package com.ccb.controller;

import com.ccb.common.urls.teacher.TeacherUrl;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.vo.req.teacher.*;
import com.ccb.domain.vo.resp.teacher.PersonalCenterResp;
import com.ccb.domain.vo.resp.teacher.ScoreStaticsResp;
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
 * @Description: 教师相关接口
 * @Author: CCB
 * @Date: 2023/2/10 09:49
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "教师相关接口")
public class TeacherController {

    @ApiOperation("教师个人中心详情")
    @GetMapping(TeacherUrl.PERSONAL_CENTER)
    @ResponseBody
    public ResultInfo<PersonalCenterResp> personalCenter() {
        return ResultInfo.success();
    }

    @ApiOperation("教师个人中心详情修改")
    @PostMapping(TeacherUrl.PERSONAL_CENTER_MODIFY)
    @ResponseBody
    public ResultInfo<Boolean> personalCenterModify(@RequestBody PersonalCenterModifyReq personalCenterModifyReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程发布/修改")
    @PostMapping(TeacherUrl.COURSE_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> coursePublish(@RequestBody CoursePublishReq coursePublishReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程删除")
    @PostMapping(TeacherUrl.COURSE_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> courseDelete(@RequestBody CourseDeleteReq courseDeleteReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程章节树新增/修改")
    @PostMapping(TeacherUrl.CHAPTER_TREE_MODIFY)
    @ResponseBody
    public ResultInfo<Boolean> chapterTreeModify(@RequestBody ChapterTreeModifyReq chapterTreeModifyReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程章节树删除")
    @PostMapping(TeacherUrl.CHAPTER_TREE_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> chapterTreeDelete(@RequestBody ChapterTreeDeleteReq chapterTreeDeleteReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程章节内容新增/修改")
    @PostMapping(TeacherUrl.CHAPTER_CONTENT_MODIFY)
    @ResponseBody
    public ResultInfo<Boolean> chapterContentModify(@RequestBody ChapterContentModifyReq chapterContentModifyReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程章节内容删除")
    @PostMapping(TeacherUrl.CHAPTER_CONTENT_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> chapterContentDelete(@RequestBody ChapterContentDeleteReq chapterContentDeleteReq) {
        return ResultInfo.success();
    }

    @ApiOperation("作业/练习发布")
    @PostMapping(TeacherUrl.EXERCISE_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> exercisePublish(@RequestBody ExercisePublishReq exercisePublishReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程成绩统计模块")
    @GetMapping(TeacherUrl.SCORE_STATICS)
    @ResponseBody
    public ResultInfo<ScoreStaticsResp> scoreStatics(ScoreStaticsReq scoreStaticsReq) {
        return ResultInfo.success();
    }

    @ApiOperation("分享发布/修改")
    @PostMapping(TeacherUrl.SHARE_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> sharePublish(@RequestBody SharePublishReq sharePublishReq) {
        return ResultInfo.success();
    }

    @ApiOperation("分享删除")
    @PostMapping(TeacherUrl.SHARE_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> shareDelete(@RequestBody ShareDeleteReq shareDeleteReq) {
        return ResultInfo.success();
    }

}
