package com.ccb.controller;

import com.ccb.common.urls.CommonUrl;
import com.ccb.common.urls.UserUrl;
import com.ccb.domain.bo.ExerciseBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.po.*;
import com.ccb.domain.vo.req.user.*;
import com.ccb.domain.vo.resp.UserResp;
import com.ccb.domain.vo.resp.user.ChapterContentResp;
import com.ccb.domain.vo.resp.user.ChapterTreeResp;
import com.ccb.domain.vo.resp.user.LoginResp;
import com.ccb.domain.vo.resp.user.RegisterResp;
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

        return ResultInfo.success();
    }

    @ApiOperation("注册信息提交")
    @PostMapping(UserUrl.REGISTER_SUBMIT)
    @ResponseBody
    public ResultInfo<Boolean> registerSubmit(@RequestBody RegisterSubmitReq registerSubmitReq) {

        return ResultInfo.success();
    }

    @ApiOperation("修改密码")
    @PostMapping(CommonUrl.UPDATE_PASSWORD)
    @ResponseBody
    public ResultInfo<Boolean> updatePassword(@RequestBody UpdatePasswordReq updatePasswordReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程列表信息")
    @GetMapping(CommonUrl.COURSE)
    @ResponseBody
    public ResultInfo<PageResp<CoursePO>> course(CourseReq courseReq) {
        // 获取token，如果是老师，只展示老师的授课
        return ResultInfo.success();
    }

    @ApiOperation("课程章节树信息")
    @GetMapping(CommonUrl.CHAPTER_TREE)
    @ResponseBody
    public ResultInfo<ChapterTreeResp> chapterTree(ChapterTreeReq chapterTreeReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程章节内容")
    @GetMapping(CommonUrl.CHAPTER_CONTENT)
    @ResponseBody
    public ResultInfo<ChapterContentResp> chapterContent(ChapterContentReq chapterContentReq) {
        return ResultInfo.success();
    }

    @ApiOperation("作业/练习信息")
    @GetMapping(CommonUrl.EXERCISE)
    @ResponseBody
    public ResultInfo<PageResp<ExerciseBO>> exercise(ExerciseReq exerciseReq) {
        return ResultInfo.success();
    }

    @ApiOperation("课程资料")
    @GetMapping(CommonUrl.RESOURCE)
    @ResponseBody
    public ResultInfo<PageResp<FilePO>> resource(ResourceReq resourceReq) {
        return ResultInfo.success();
    }

    @ApiOperation("讨论详情")
    @GetMapping(CommonUrl.FORUM)
    @ResponseBody
    public ResultInfo<PageResp<ForumPO>> forum(ForumReq forumReq) {
        return ResultInfo.success();
    }

    @ApiOperation("发布讨论")
    @PostMapping(CommonUrl.FORUM_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> forumPublish(@RequestBody ForumPublishReq forumPublishReq) {
        return ResultInfo.success();
    }

    @ApiOperation("删除讨论")
    @PostMapping(CommonUrl.FORUM_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> forumDelete(@RequestBody ForumDeleteReq forumDeleteReq) {
        return ResultInfo.success();
    }

    @ApiOperation("分享页面信息")
    @PostMapping(CommonUrl.SHARE)
    @ResponseBody
    public ResultInfo<PageResp<SharePO>> share(@RequestBody ShareReq shareReq) {
        return ResultInfo.success();
    }

    @ApiOperation("评论详情")
    @GetMapping(CommonUrl.COMMENT)
    @ResponseBody
    public ResultInfo<PageResp<CommentPO>> comment(CommentReq commentReq) {
        return ResultInfo.success();
    }

    @ApiOperation("发布评论")
    @GetMapping(CommonUrl.COMMENT_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> commentPublish(CommentPublishReq commentPublishReq) {
        // 获取用户信息进行处理
        return ResultInfo.success();
    }

    @ApiOperation("评论删除")
    @GetMapping(CommonUrl.COMMENT_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> comment(CommentDeleteReq commentDeleteReq) {
        return ResultInfo.success();
    }

    @ApiOperation("根据token获取用户信息（包括头像）")
    @GetMapping(CommonUrl.USER_INFO)
    @ResponseBody
    public ResultInfo<UserResp> userInfo(String token) {
        return ResultInfo.success();
    }
}
