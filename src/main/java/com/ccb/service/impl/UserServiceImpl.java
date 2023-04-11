package com.ccb.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ccb.common.constants.CommonConstant;
import com.ccb.common.constants.RedisConstant;
import com.ccb.common.enums.BooleanEnum;
import com.ccb.common.enums.UserTypeEnum;
import com.ccb.common.utils.CollectionUtil;
import com.ccb.common.utils.RedisUtil;
import com.ccb.context.ApplicationContext;
import com.ccb.domain.bo.User;
import com.ccb.domain.po.ClassPO;
import com.ccb.domain.po.CoursePO;
import com.ccb.domain.po.FilePO;
import com.ccb.domain.po.StudentPO;
import com.ccb.domain.po.TeacherPO;
import com.ccb.domain.vo.req.teacher.CoursePublishReq;
import com.ccb.domain.vo.req.teacher.PersonalCenterModifyReq;
import com.ccb.domain.vo.req.user.LoginReq;
import com.ccb.domain.vo.req.user.RegisterReq;
import com.ccb.domain.vo.req.user.RegisterSubmitReq;
import com.ccb.domain.vo.req.user.UpdatePasswordReq;
import com.ccb.domain.vo.resp.student.PersonalCenterResp;
import com.ccb.domain.vo.resp.user.LoginResp;
import com.ccb.domain.vo.resp.user.RegisterResp;
import com.ccb.exception.BizException;
import com.ccb.mapper.ClassMapper;
import com.ccb.mapper.CourseMapper;
import com.ccb.mapper.StudentMapper;
import com.ccb.mapper.TeacherMapper;
import com.ccb.service.FileService;
import com.ccb.service.MailService;
import com.ccb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;

/**
 * @Description: 用户服务
 * @Author: CCB
 * @Date: 2023/3/2 16:23
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final TeacherMapper teacherMapper;

    private final StudentMapper studentMapper;

    private final ClassMapper classMapper;

    private final FileService fileService;

    private final MailService mailService;

    private final CourseMapper courseMapper;

    @Override
    public LoginResp login(LoginReq loginReq) {
        User user;
        if (Objects.equals(loginReq.getType(), UserTypeEnum.STUDENT.getIndex())) {
            StudentPO studentPO = new StudentPO();
            BeanUtils.copyProperties(loginReq, studentPO);
            user = getUser(studentPO);
        } else if (Objects.equals(loginReq.getType(), UserTypeEnum.TEACHER.getIndex())) {
            TeacherPO teacherPO = new TeacherPO();
            BeanUtils.copyProperties(loginReq, teacherPO);
            user = getUser(teacherPO);
        } else {
            throw new BizException("用户类型枚举值不合法");
        }
        // 放入缓存
        String token = JWT.create()
                .withAudience(user.getName())
                .sign(Algorithm.HMAC256(CommonConstant.ENCRYPT_KEY));
        RedisUtil.cacheValue(token, user, CommonConstant.REDIS_EXPIRED_TIME);
        ApplicationContext.setUser(user);
        LoginResp loginResp = new LoginResp();
        loginResp.setToken(token);
        return loginResp;
    }

    @Override
    public RegisterResp registerInfo(RegisterReq registerReq) {
        // 先查学生，没有再查老师
        RegisterResp registerResp = new RegisterResp();
        TeacherPO teacherPO = new TeacherPO();
        BeanUtils.copyProperties(registerReq, teacherPO);
        User user = getUser(teacherPO);
        if (Objects.isNull(user.getId())) {
            // 查学生
            StudentPO studentPO = new StudentPO();
            BeanUtils.copyProperties(registerReq, studentPO);
            user = getUser(studentPO);
            // 学生，查询班级名称
            studentPO = studentMapper.selectByPrimaryKey(user.getId());
            ClassPO classPO = classMapper.selectByPrimaryKey(studentPO.getClassId());
            registerResp.setClassName(classPO.getName());
        }
        BeanUtils.copyProperties(user, registerResp);
        return registerResp;
    }

    /**
     * 查询用户,在学生表中
     *
     * @param studentPO
     * @return
     */
    private User getUser(StudentPO studentPO) {
        User user = new User();
        List<StudentPO> studentPOList = studentMapper.queryStudent(studentPO);
        if (CollectionUtil.isSingleElement(studentPOList)) {
            BeanUtils.copyProperties(studentPOList.get(0), user);
            FilePO filePO = fileService.queryAvatar(user.getId());
            user.setAvatarUrl(filePO.getUrl());
            user.setAvatarId(filePO.getId());
        } else {
            throw new BizException("查询用户信息异常");
        }
        return user;
    }

    /**
     * 查询用户,在教师表中
     *
     * @param teacherPO
     * @return
     */
    private User getUser(TeacherPO teacherPO) {
        User user = new User();
        List<TeacherPO> teacherPOList = teacherMapper.queryTeacher(teacherPO);
        if (CollectionUtil.isSingleElement(teacherPOList)) {
            BeanUtils.copyProperties(teacherPOList.get(0), user);
            FilePO filePO = fileService.queryAvatar(user.getId());
            user.setAvatarUrl(filePO.getUrl());
            user.setAvatarId(filePO.getId());
        } else {
            throw new BizException("查询用户信息异常");
        }
        return user;
    }

    /**
     * 预检查邮箱/手机号是否唯一
     * TODO 单独校验手机号/邮箱唯一才是
     *
     * @param registerSubmitReq
     * @return
     */
    private Boolean preCheck(RegisterSubmitReq registerSubmitReq) {
        TeacherPO teacherPO = new TeacherPO();
        teacherPO.setEmail(registerSubmitReq.getEmail());
        teacherPO.setPhone(registerSubmitReq.getPhone());
        List<TeacherPO> teacherPOList = teacherMapper.queryTeacher(teacherPO);
        if (CollectionUtil.isEmpty(teacherPOList)) {
            StudentPO studentPO = new StudentPO();
            studentPO.setEmail(registerSubmitReq.getEmail());
            studentPO.setPhone(registerSubmitReq.getPhone());
            List<StudentPO> studentPOS = studentMapper.queryStudent(studentPO);
            if (CollectionUtil.isEmpty(studentPOS)) {
                return true;
            }
        }
        throw new BizException("注册的手机号或者邮箱重复！");
    }

    @Override
    public Boolean registerSubmit(RegisterSubmitReq registerSubmitReq) {
        preCheck(registerSubmitReq);
        if (Objects.equals(registerSubmitReq.getIsTeacher(), BooleanEnum.YES)) {
            if (Objects.isNull(registerSubmitReq.getId())) {
                TeacherPO teacherPO = new TeacherPO();
                BeanUtils.copyProperties(registerSubmitReq, teacherPO);
                teacherPO.setId(null);
                teacherMapper.insert(teacherPO);
            } else {
                TeacherPO teacherPO = new TeacherPO();
                BeanUtils.copyProperties(registerSubmitReq, teacherPO);
                teacherMapper.updateByPrimaryKey(teacherPO);
            }
        } else {
            if (Objects.isNull(registerSubmitReq.getId())) {
                StudentPO studentPO = new StudentPO();
                BeanUtils.copyProperties(registerSubmitReq, studentPO);
                studentPO.setId(null);
                studentMapper.insert(studentPO);
            } else {
                StudentPO studentPO = new StudentPO();
                BeanUtils.copyProperties(registerSubmitReq, studentPO);
                studentMapper.updateByPrimaryKey(studentPO);
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean updatePassword(UpdatePasswordReq updatePasswordReq) {
        User user = ApplicationContext.getUser();
        if (! Objects.equals(user.getEmail(), updatePasswordReq.getEmail())) {
            throw new BizException("登录用户与传入的邮箱值不同");
        }
        String key = RedisConstant.CAPTCHA_KEY + user.getPhone();
        if (! RedisUtil.containsValueKey(key)) {
            throw new BizException("验证码已经过期");
        }
        String value = (String) RedisUtil.getValue(key);
        if (! Objects.equals(value, updatePasswordReq.getVerificationCode())) {
            throw new BizException("验证码错误");
        }
        if (Objects.equals(UserTypeEnum.STUDENT.getIndex(), user.getUserType())) {
            StudentPO studentPO = new StudentPO();
            studentPO.setId(user.getId());
            studentPO.setPassword(updatePasswordReq.getNewPwd());
            studentMapper.updateByPrimaryKey(studentPO);
        } else {
            TeacherPO teacherPO = new TeacherPO();
            teacherPO.setId(user.getId());
            teacherPO.setPassword(updatePasswordReq.getNewPwd());
            teacherMapper.updateByPrimaryKey(teacherPO);
        }
        return true;
    }

    @Override
    public User queryUserById(Long id) {
        User user = new User();
        TeacherPO teacherPO = new TeacherPO();
        teacherPO.setId(id);
        List<TeacherPO> teacherPOList = teacherMapper.queryTeacher(teacherPO);
        if (CollectionUtil.isSingleElement(teacherPOList)) {
            BeanUtils.copyProperties(teacherPOList.get(0), user);
            user.setUserType(UserTypeEnum.TEACHER.getIndex());
        } else {
            StudentPO studentPO = new StudentPO();
            studentPO.setId(id);
            List<StudentPO> studentPOList = studentMapper.queryStudent(studentPO);
            if (CollectionUtil.isSingleElement(studentPOList)) {
                BeanUtils.copyProperties(studentPOList.get(0), user);
                user.setUserType(UserTypeEnum.STUDENT.getIndex());
            } else {
                throw new BizException("查询用户信息异常");
            }
        }
        return user;
    }

    @Override
    public PersonalCenterResp queryStudentDetailById(Long id) {
        StudentPO studentPO = new StudentPO();
        studentPO.setId(id);
        User user = getUser(studentPO);
        // 查询班级
        ClassPO classPO = classMapper.selectByPrimaryKey(user.getClassId());
        PersonalCenterResp personalCenterResp = new PersonalCenterResp();
        BeanUtils.copyProperties(user, personalCenterResp);
        personalCenterResp.setClazz(classPO);
        return personalCenterResp;
    }

    @Override
    public com.ccb.domain.vo.resp.teacher.PersonalCenterResp queryTeacherDetailById(Long id) {
        TeacherPO teacherPO = new TeacherPO();
        teacherPO.setId(id);
        User user = getUser(teacherPO);
        // 查询管理的班级
        Example example = new Example(ClassPO.class);
        example.clear();
        example.createCriteria()
                .andEqualTo("teacher_id", id);
        List<ClassPO> classPOS = classMapper.selectByExample(example);
        com.ccb.domain.vo.resp.teacher.PersonalCenterResp personalCenterResp = new com.ccb.domain.vo.resp.teacher.PersonalCenterResp();
        BeanUtils.copyProperties(user, personalCenterResp);
        personalCenterResp.setClassList(classPOS);
        return personalCenterResp;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTeacherById(PersonalCenterModifyReq personalCenterModifyReq) {
        TeacherPO teacherPO = new TeacherPO();
        BeanUtils.copyProperties(personalCenterModifyReq, teacherPO);
        teacherMapper.updateByPrimaryKey(teacherPO);
        Example example = new Example(ClassPO.class);
        example.clear();
        example.createCriteria()
                .andIn("id", personalCenterModifyReq.getClassIdList());
        ClassPO classPO = new ClassPO();
        classPO.setTeacherId(personalCenterModifyReq.getId());
        classMapper.updateByExample(classPO, example);
    }

    @Override
    public void updateStudentById(StudentPO studentPO) {
        studentMapper.updateByPrimaryKey(studentPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void publishCourse(CoursePublishReq coursePublishReq) {
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(coursePublishReq, coursePO);
        if (Objects.isNull(coursePublishReq.getId())) {
            // 新增
            courseMapper.insert(coursePO);
        } else {
            // 修改
            courseMapper.updateByPrimaryKey(coursePO);
        }
        fileService.saveFile(coursePublishReq.getFileList(), coursePO.getId());
    }
}
