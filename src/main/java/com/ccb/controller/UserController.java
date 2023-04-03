package com.ccb.controller;

import com.ccb.common.annotations.MethodLog;
import com.ccb.common.enums.UserTypeEnum;
import com.ccb.common.urls.CommonUrl;
import com.ccb.common.urls.UserUrl;
import com.ccb.common.utils.RedisUtil;
import com.ccb.context.ApplicationContext;
import com.ccb.domain.bo.CommentBO;
import com.ccb.domain.bo.CourseBO;
import com.ccb.domain.bo.ExerciseBO;
import com.ccb.domain.bo.ExerciseQueryBO;
import com.ccb.domain.bo.FileBO;
import com.ccb.domain.bo.ForumBO;
import com.ccb.domain.bo.ShareBO;
import com.ccb.domain.bo.User;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.po.ChapterContentPO;
import com.ccb.domain.po.CommentPO;
import com.ccb.domain.po.CoursePO;
import com.ccb.domain.po.FilePO;
import com.ccb.domain.po.ForumPO;
import com.ccb.domain.po.SharePO;
import com.ccb.domain.vo.req.user.ChapterContentReq;
import com.ccb.domain.vo.req.user.ChapterTreeReq;
import com.ccb.domain.vo.req.user.CommentDeleteReq;
import com.ccb.domain.vo.req.user.CommentPublishReq;
import com.ccb.domain.vo.req.user.CommentReq;
import com.ccb.domain.vo.req.user.CourseReq;
import com.ccb.domain.vo.req.user.ExerciseReq;
import com.ccb.domain.vo.req.user.ForumDeleteReq;
import com.ccb.domain.vo.req.user.ForumPublishReq;
import com.ccb.domain.vo.req.user.ForumReq;
import com.ccb.domain.vo.req.user.LoginReq;
import com.ccb.domain.vo.req.user.RegisterReq;
import com.ccb.domain.vo.req.user.RegisterSubmitReq;
import com.ccb.domain.vo.req.user.ResourceReq;
import com.ccb.domain.vo.req.user.ShareReq;
import com.ccb.domain.vo.req.user.UpdatePasswordReq;
import com.ccb.domain.vo.resp.UserResp;
import com.ccb.domain.vo.resp.user.ChapterContentResp;
import com.ccb.domain.vo.resp.user.ChapterTreeResp;
import com.ccb.domain.vo.resp.user.LoginResp;
import com.ccb.domain.vo.resp.user.RegisterResp;
import com.ccb.exception.BizException;
import com.ccb.service.ChapterService;
import com.ccb.service.CommentService;
import com.ccb.service.CourseService;
import com.ccb.service.ExerciseService;
import com.ccb.service.FileService;
import com.ccb.service.ForumService;
import com.ccb.service.ShareService;
import com.ccb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Objects;

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

    private final UserService userService;

    private final CourseService courseService;

    private final ChapterService chapterService;

    private final ExerciseService exerciseService;

    private final FileService fileService;

    private final ForumService forumService;

    private final ShareService shareService;

    private final CommentService commentService;

    @MethodLog
    @ApiOperation("登录")
    @PostMapping(UserUrl.LOGIN)
    @ResponseBody
    public ResultInfo<LoginResp> login(@RequestBody LoginReq loginReq) {
        if (Objects.isNull(loginReq.getPhone()) && Objects.isNull(loginReq.getEmail())) {
            throw new BizException("请输入手机号或者邮箱");
        }
        return ResultInfo.success(userService.login(loginReq));
    }

    @MethodLog
    @ApiOperation("注册信息详情")
    @PostMapping(UserUrl.REGISTER)
    @ResponseBody
    public ResultInfo<RegisterResp> register(@RequestBody RegisterReq registerReq) {
        return ResultInfo.success(userService.registerInfo(registerReq));
    }

    @MethodLog
    @ApiOperation("注册信息提交")
    @PostMapping(UserUrl.REGISTER_SUBMIT)
    @ResponseBody
    public ResultInfo<Boolean> registerSubmit(@RequestBody RegisterSubmitReq registerSubmitReq) {
        return ResultInfo.success(userService.registerSubmit(registerSubmitReq));
    }

    @MethodLog
    @ApiOperation("修改密码")
    @PostMapping(CommonUrl.UPDATE_PASSWORD)
    @ResponseBody
    public ResultInfo<Boolean> updatePassword(@RequestBody UpdatePasswordReq updatePasswordReq) {
        return ResultInfo.success(userService.updatePassword(updatePasswordReq));
    }

    @MethodLog
    @ApiOperation("课程列表信息")
    @GetMapping(CommonUrl.COURSE)
    @ResponseBody
    public ResultInfo<PageResp<CoursePO>> course(CourseReq courseReq) {
        // 如果是老师，只展示老师的授课
        // TODO 如果是学生，展示关联班级的老师的授课
        User user = ApplicationContext.getUser();
        CourseBO courseBO = new CourseBO();
        BeanUtils.copyProperties(courseReq, courseBO);
        if (Objects.equals(UserTypeEnum.TEACHER.getIndex(), user.getUserType())) {
            courseBO.setTeacherId(user.getId());
        }
        return ResultInfo.success(courseService.queryCourse(courseBO));
    }

    @MethodLog
    @ApiOperation("课程章节树信息")
    @GetMapping(CommonUrl.CHAPTER_TREE)
    @ResponseBody
    public ResultInfo<ChapterTreeResp> chapterTree(ChapterTreeReq chapterTreeReq) {
        return ResultInfo.success(chapterService.queryChapterTree(chapterTreeReq.getCourseId()));
    }

    @MethodLog
    @ApiOperation("课程章节内容")
    @GetMapping(CommonUrl.CHAPTER_CONTENT)
    @ResponseBody
    public ResultInfo<ChapterContentResp> chapterContent(ChapterContentReq chapterContentReq) {
        ChapterContentPO chapterContentPO = chapterService.queryChapterContentByChapterId(chapterContentReq.getChapterContentId());
        ChapterContentResp chapterContentResp = new ChapterContentResp();
        BeanUtils.copyProperties(chapterContentPO, chapterContentResp);
        return ResultInfo.success(chapterContentResp);
    }

    @MethodLog
    @ApiOperation("作业/练习信息")
    @GetMapping(CommonUrl.EXERCISE)
    @ResponseBody
    public ResultInfo<PageResp<ExerciseBO>> exercise(ExerciseReq exerciseReq) {
        ExerciseQueryBO exerciseQueryBO = new ExerciseQueryBO();
        BeanUtils.copyProperties(exerciseReq, exerciseQueryBO);
        return ResultInfo.success(exerciseService.queryExercise(exerciseQueryBO));
    }

    @MethodLog
    @ApiOperation("课程资料")
    @GetMapping(CommonUrl.RESOURCE)
    @ResponseBody
    public ResultInfo<PageResp<FilePO>> resource(ResourceReq resourceReq) {
        FileBO fileBO = new FileBO();
        BeanUtils.copyProperties(resourceReq, fileBO);
        fileBO.setLinkId(resourceReq.getCourseId());
        return ResultInfo.success(fileService.queryFile(fileBO));
    }

    @MethodLog
    @ApiOperation("讨论详情")
    @GetMapping(CommonUrl.FORUM)
    @ResponseBody
    public ResultInfo<PageResp<ForumPO>> forum(ForumReq forumReq) {
        ForumBO forumBO = new ForumBO();
        BeanUtils.copyProperties(forumReq, forumBO);
        return ResultInfo.success(forumService.queryForum(forumBO));
    }

    @MethodLog
    @ApiOperation("发布讨论")
    @PostMapping(CommonUrl.FORUM_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> forumPublish(@RequestBody ForumPublishReq forumPublishReq) {
        ForumPO forumPO = new ForumPO();
        BeanUtils.copyProperties(forumPublishReq, forumPO);
        forumService.insertForum(forumPO);
        return ResultInfo.success(Boolean.TRUE);
    }

    @MethodLog
    @ApiOperation("删除讨论")
    @PostMapping(CommonUrl.FORUM_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> forumDelete(@RequestBody ForumDeleteReq forumDeleteReq) {
        forumService.deleteFormById(forumDeleteReq.getId());
        return ResultInfo.success(Boolean.TRUE);
    }

    @MethodLog
    @ApiOperation("分享页面信息")
    @PostMapping(CommonUrl.SHARE)
    @ResponseBody
    public ResultInfo<PageResp<SharePO>> share(@RequestBody ShareReq shareReq) {
        ShareBO shareBO = new ShareBO();
        // TODO List没有拷贝？
        BeanUtils.copyProperties(shareReq, shareBO);
        return ResultInfo.success(shareService.queryShare(shareBO));
    }

    @MethodLog
    @ApiOperation("评论详情")
    @GetMapping(CommonUrl.COMMENT)
    @ResponseBody
    public ResultInfo<PageResp<CommentPO>> comment(CommentReq commentReq) {
        CommentBO commentBO = new CommentBO();
        BeanUtils.copyProperties(commentReq, commentBO);
        return ResultInfo.success(commentService.queryComment(commentBO));
    }

    @MethodLog
    @ApiOperation("发布评论")
    @GetMapping(CommonUrl.COMMENT_PUBLISH)
    @ResponseBody
    public ResultInfo<Boolean> commentPublish(CommentPublishReq commentPublishReq) {
        // 获取用户信息进行处理
        User user = ApplicationContext.getUser();
        CommentPO commentPO = new CommentPO();
        BeanUtils.copyProperties(commentPublishReq, commentPO);
        commentPO.setUserId(user.getId());
        commentPO.setUserName(user.getName());
        commentPO.setUserAvatar(user.getAvatarUrl());
        commentService.insertComment(commentPO);
        return ResultInfo.success(Boolean.TRUE);
    }

    @MethodLog
    @ApiOperation("评论删除")
    @GetMapping(CommonUrl.COMMENT_DELETE)
    @ResponseBody
    public ResultInfo<Boolean> comment(CommentDeleteReq commentDeleteReq) {
        commentService.deleteCommentById(commentDeleteReq.getId());
        return ResultInfo.success(Boolean.TRUE);
    }

    @MethodLog
    @ApiOperation("根据token获取用户信息（包括头像）")
    @GetMapping(CommonUrl.USER_INFO)
    @ResponseBody
    public ResultInfo<UserResp> userInfo(String token) {
        User user = (User) RedisUtil.getValue(token);
        if (Objects.isNull(user)) {
            throw new BizException("登录过期");
        }
        if (!Objects.equals(user, ApplicationContext.getUser())) {
            throw new BizException("登录用户不一致");
        }
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        return ResultInfo.success(userResp);
    }
}
