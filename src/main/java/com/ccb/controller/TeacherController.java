package com.ccb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.ccb.common.urls.teacher.TeacherUrl;
import com.ccb.context.ApplicationContext;
import com.ccb.domain.bo.User;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.po.ChapterPO;
import com.ccb.domain.po.SharePO;
import com.ccb.domain.vo.req.teacher.ChapterContentDeleteReq;
import com.ccb.domain.vo.req.teacher.ChapterContentModifyReq;
import com.ccb.domain.vo.req.teacher.ChapterTreeDeleteReq;
import com.ccb.domain.vo.req.teacher.ChapterTreeModifyReq;
import com.ccb.domain.vo.req.teacher.CourseDeleteReq;
import com.ccb.domain.vo.req.teacher.CoursePublishReq;
import com.ccb.domain.vo.req.teacher.ExercisePublishReq;
import com.ccb.domain.vo.req.teacher.PersonalCenterModifyReq;
import com.ccb.domain.vo.req.teacher.ScoreStaticsReq;
import com.ccb.domain.vo.req.teacher.ShareDeleteReq;
import com.ccb.domain.vo.req.teacher.SharePublishReq;
import com.ccb.domain.vo.resp.teacher.PersonalCenterResp;
import com.ccb.domain.vo.resp.teacher.ScoreStaticsResp;
import com.ccb.service.ChapterService;
import com.ccb.service.CourseService;
import com.ccb.service.ExerciseService;
import com.ccb.service.ShareService;
import com.ccb.service.UserService;
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

    private final UserService userService;

    private final CourseService courseService;

    private final ChapterService chapterService;

    private final ExerciseService exerciseService;

    private final ShareService shareService;

    @ApiOperation("教师个人中心详情")
    @GetMapping(TeacherUrl.PERSONAL_CENTER)
    @ResponseBody
    public ResultInfo<PersonalCenterResp> personalCenter() {
        User user = ApplicationContext.getUser();
        return ResultInfo.success(userService.queryTeacherDetailById(user.getId()));
    }

    @ApiOperation("教师个人中心详情修改")
    @PostMapping(TeacherUrl.PERSONAL_CENTER_MODIFY)
    @ResponseBody
    public ResultInfo<Boolean> personalCenterModify(@RequestBody PersonalCenterModifyReq personalCenterModifyReq) {
        userService.updateTeacherById(personalCenterModifyReq);
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("课程发布/修改")
    @PostMapping(TeacherUrl.COURSE_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> coursePublish(@RequestBody CoursePublishReq coursePublishReq) {
        userService.publishCourse(coursePublishReq);
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("课程删除")
    @PostMapping(TeacherUrl.COURSE_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> courseDelete(@RequestBody CourseDeleteReq courseDeleteReq) {
        courseService.deleteCourseById(courseDeleteReq.getId());
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("课程章节树新增/修改")
    @PostMapping(TeacherUrl.CHAPTER_TREE_MODIFY)
    @ResponseBody
    public ResultInfo<Boolean> chapterTreeModify(@RequestBody ChapterTreeModifyReq chapterTreeModifyReq) {
        ChapterPO chapterPO = new ChapterPO();
        BeanUtil.copyProperties(chapterTreeModifyReq, chapterPO);
        chapterService.saveChapter(chapterPO);
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("课程章节树删除")
    @PostMapping(TeacherUrl.CHAPTER_TREE_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> chapterTreeDelete(@RequestBody ChapterTreeDeleteReq chapterTreeDeleteReq) {
        chapterService.deleteChapterById(chapterTreeDeleteReq.getId());
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("课程章节内容新增/修改")
    @PostMapping(TeacherUrl.CHAPTER_CONTENT_MODIFY)
    @ResponseBody
    public ResultInfo<Boolean> chapterContentModify(@RequestBody ChapterContentModifyReq chapterContentModifyReq) {
        chapterService.saveChapterContent(chapterContentModifyReq);
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("课程章节内容删除")
    @PostMapping(TeacherUrl.CHAPTER_CONTENT_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> chapterContentDelete(@RequestBody ChapterContentDeleteReq chapterContentDeleteReq) {
        chapterService.deleteChapterContentById(chapterContentDeleteReq.getId());
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("作业/练习发布")
    @PostMapping(TeacherUrl.EXERCISE_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> exercisePublish(@RequestBody ExercisePublishReq exercisePublishReq) {
        exerciseService.saveExercise(exercisePublishReq);
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("课程成绩统计模块")
    @GetMapping(TeacherUrl.SCORE_STATICS)
    @ResponseBody
    public ResultInfo<ScoreStaticsResp> scoreStatics(ScoreStaticsReq scoreStaticsReq) {
        return ResultInfo.success(courseService.courseStatics(scoreStaticsReq.getCourseId()));
    }

    @ApiOperation("分享发布/修改")
    @PostMapping(TeacherUrl.SHARE_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> sharePublish(@RequestBody SharePublishReq sharePublishReq) {
        SharePO sharePO = new SharePO();
        BeanUtil.copyProperties(sharePublishReq, sharePO);
        shareService.saveShare(sharePO);
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("分享删除")
    @PostMapping(TeacherUrl.SHARE_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> shareDelete(@RequestBody ShareDeleteReq shareDeleteReq) {
        shareService.deleteShareById(shareDeleteReq.getId());
        return ResultInfo.success(Boolean.TRUE);
    }

}
