package com.ccb.controller;

import com.ccb.common.urls.FileUrl;
import com.ccb.common.urls.teacher.AuditUrl;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.vo.req.audit.AuditReq;
import com.ccb.domain.vo.req.file.DeleteReq;
import com.ccb.domain.vo.req.file.UploadReq;
import com.ccb.domain.vo.req.file.ViewReq;
import com.ccb.domain.vo.resp.audit.AuditResp;
import com.ccb.domain.vo.resp.file.ViewResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 文件相关接口
 * @Author: CCB
 * @Date: 2023/2/10 10:28
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "文件相关接口")
public class FileController {

    @ApiOperation("文件列表")
    @GetMapping(FileUrl.VIEW)
    @ResponseBody
    public ResultInfo<ViewResp> view(ViewReq viewReq) {
        return ResultInfo.success();
    }

    @ApiOperation("文件上传")
    @GetMapping(FileUrl.UPLOAD)
    @ResponseBody
    public ResultInfo<Boolean> upload(UploadReq uploadReq) {
        return ResultInfo.success();
    }

    @ApiOperation("文件删除")
    @GetMapping(FileUrl.DELETE)
    @ResponseBody
    public ResultInfo<Boolean> delete(DeleteReq deleteReq) {
        return ResultInfo.success();
    }

}
