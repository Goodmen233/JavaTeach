package com.ccb.controller;

import com.ccb.common.urls.teacher.AuditUrl;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.vo.req.audit.AuditDetailReq;
import com.ccb.domain.vo.req.audit.AuditFailReq;
import com.ccb.domain.vo.req.audit.AuditPassReq;
import com.ccb.domain.vo.req.audit.AuditReq;
import com.ccb.domain.vo.resp.audit.AuditDetailResp;
import com.ccb.domain.vo.resp.audit.AuditResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @ApiOperation("待审核列表")
    @GetMapping(AuditUrl.AUDIT)
    @ResponseBody
    public ResultInfo<List<AuditResp>> audit() {
        return ResultInfo.success();
    }

    @ApiOperation("审核详情")
    @GetMapping(AuditUrl.DETAIL)
    @ResponseBody
    public ResultInfo<AuditDetailResp> auditDetail(AuditDetailReq auditDetailReq) {
        return ResultInfo.success();
    }

    @ApiOperation("审核通过")
    @PostMapping(AuditUrl.PASS)
    @ResponseBody
    public ResultInfo<Boolean> auditPass(AuditPassReq auditPassReq) {
        return ResultInfo.success();
    }

    @ApiOperation("审核不通过")
    @GetMapping(AuditUrl.FAIL)
    @ResponseBody
    public ResultInfo<Boolean> auditFail(AuditFailReq auditFailReq) {
        return ResultInfo.success();
    }

}
