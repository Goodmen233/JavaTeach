package com.ccb.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ccb.common.constants.CommonConstant;
import com.ccb.common.constants.RedisConstant;
import com.ccb.common.enums.UserTypeEnum;
import com.ccb.common.utils.CollectionUtil;
import com.ccb.common.utils.RedisUtil;
import com.ccb.domain.bo.User;
import com.ccb.domain.po.ClassPO;
import com.ccb.domain.po.StudentPO;
import com.ccb.domain.po.TeacherPO;
import com.ccb.domain.vo.req.user.LoginReq;
import com.ccb.domain.vo.req.user.RegisterReq;
import com.ccb.domain.vo.req.user.RegisterSubmitReq;
import com.ccb.domain.vo.req.user.UpdatePasswordReq;
import com.ccb.domain.vo.resp.user.LoginResp;
import com.ccb.domain.vo.resp.user.RegisterResp;
import com.ccb.exception.BizException;
import com.ccb.mapper.ClassMapper;
import com.ccb.mapper.StudentMapper;
import com.ccb.mapper.TeacherMapper;
import com.ccb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

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
        } else {
            throw new BizException("查询用户信息异常");
        }
        return user;
    }

    @Override
    public Boolean registerSubmit(RegisterSubmitReq registerSubmitReq) {
        return null;
    }

    @Override
    public Boolean updatePassword(UpdatePasswordReq updatePasswordReq) {
        return null;
    }
}
