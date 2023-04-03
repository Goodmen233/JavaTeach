package com.ccb.service.impl;

import com.ccb.common.enums.AuditEnum;
import com.ccb.common.enums.UserTypeEnum;
import com.ccb.domain.bo.AuditBO;
import com.ccb.domain.bo.User;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.StudentPO;
import com.ccb.domain.po.TeacherPO;
import com.ccb.domain.po.UserPO;
import com.ccb.domain.vo.resp.audit.AuditDetailResp;
import com.ccb.mapper.StudentMapper;
import com.ccb.mapper.TeacherMapper;
import com.ccb.service.AuditService;
import com.ccb.service.UserService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Description: 审核服务实现
 * @Author: CCB
 * @Date: 2023/4/3 20:57
 */
@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final StudentMapper studentMapper;

    private final TeacherMapper teacherMapper;

    private final UserService userService;

    @Override
    public PageResp<UserPO> queryUser(AuditBO auditBO) {
        List<UserPO> userList = Lists.newArrayList();
        int size;
        if (Objects.equals(auditBO.getIsAuditStudent(), Boolean.TRUE)) {
            StudentPO studentPO = new StudentPO();
            studentPO.setAuditPhone(auditBO.getPhone());
            List<StudentPO> studentPOS = studentMapper.queryStudent(studentPO);
            size = studentPOS.size();
            studentPOS.forEach(t -> {
                UserPO userPO = new UserPO();
                BeanUtils.copyProperties(t, userPO);
                userList.add(userPO);
            });
        } else {
            TeacherPO teacherPO = new TeacherPO();
            teacherPO.setAuditPhone(auditBO.getPhone());
            List<TeacherPO> teacherPOS = teacherMapper.queryTeacher(teacherPO);
            size = teacherPOS.size();
            teacherPOS.forEach(t -> {
                UserPO userPO = new UserPO();
                BeanUtils.copyProperties(t, userPO);
                userList.add(userPO);
            });
        }
        // 分页
        int start = auditBO.getPageNo() * auditBO.getPageSize();
        int end = (auditBO.getPageNo() + 1) * auditBO.getPageSize();
        PageResp<UserPO> page = new PageResp<>();
        page.setTotal((long) size);
        page.setRows(userList.subList(start, end));
        return page;
    }

    @Override
    public AuditDetailResp queryUserDetailById(Long id) {
        User user = userService.queryUserById(id);
        // TODO 学生的班级信息？
        AuditDetailResp auditDetailResp = new AuditDetailResp();
        BeanUtils.copyProperties(user, auditDetailResp);
        return auditDetailResp;
    }

    @Override
    public void audit(Long id, Integer status) {
        User user = userService.queryUserById(id);
        if (Objects.equals(user.getUserType(), UserTypeEnum.STUDENT.getIndex())) {
            StudentPO studentPO = new StudentPO();
            studentPO.setId(user.getId());
            studentPO.setAudit(status);
            studentMapper.updateByPrimaryKey(studentPO);
        } else {
            TeacherPO teacherPO = new TeacherPO();
            teacherPO.setId(user.getId());
            teacherPO.setAudit(status);
            teacherMapper.updateByPrimaryKey(teacherPO);
        }
    }

}
