package com.ccb.controller;

import com.ccb.common.enums.AuditEnum;
import com.ccb.common.enums.UserTypeEnum;
import com.ccb.common.urls.teacher.AuditUrl;
import com.ccb.common.utils.PageUtil;
import com.ccb.context.ApplicationContext;
import com.ccb.domain.bo.AuditBO;
import com.ccb.domain.bo.User;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.vo.req.audit.AuditDetailReq;
import com.ccb.domain.vo.req.audit.AuditFailReq;
import com.ccb.domain.vo.req.audit.AuditPassReq;
import com.ccb.domain.vo.resp.audit.AuditDetailResp;
import com.ccb.domain.vo.resp.audit.AuditResp;
import com.ccb.service.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @Description: 审核接口
 * @Author: CCB
 * @Date: 2023/2/9 16:57
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "审核接口")
public class AuditController {

    public static final String DEFAULT_PHONE = "110120";

    private final AuditService auditService;

    @ApiOperation("待审核列表")
    @GetMapping(AuditUrl.AUDIT)
    @ResponseBody
    public ResultInfo<PageResp<AuditResp>> audit() {
        User user = ApplicationContext.getUser();
        if (Objects.equals(UserTypeEnum.STUDENT.getIndex(), user.getUserType())) {
            return ResultInfo.success(new PageResp<>());
        }
        AuditBO auditBO = new AuditBO();
        auditBO.setPhone(user.getPhone());
        if (Objects.equals(DEFAULT_PHONE, user.getPhone())) {
            auditBO.setIsAuditStudent(Boolean.TRUE);
        } else {
            auditBO.setIsAuditStudent(Boolean.FALSE);
        }
        PageUtil.checkPage(auditBO);
        return ResultInfo.success(auditService.queryUser(auditBO));
    }

    @ApiOperation("审核详情")
    @GetMapping(AuditUrl.DETAIL)
    @ResponseBody
    public ResultInfo<AuditDetailResp> auditDetail(AuditDetailReq auditDetailReq) {
        return ResultInfo.success(auditService.queryUserDetailById(auditDetailReq.getId()));
    }

    @ApiOperation("审核通过")
    @PostMapping(AuditUrl.PASS)
    @ResponseBody
    public ResultInfo<Boolean> auditPass(AuditPassReq auditPassReq) {
        auditService.audit(auditPassReq.getId(), AuditEnum.AUDIT_PASS.getIndex());
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("审核不通过")
    @GetMapping(AuditUrl.FAIL)
    @ResponseBody
    public ResultInfo<Boolean> auditFail(AuditFailReq auditFailReq) {
        auditService.audit(auditFailReq.getId(), AuditEnum.AUDIT_FAIL.getIndex());
        return ResultInfo.success(Boolean.TRUE);
    }

}
