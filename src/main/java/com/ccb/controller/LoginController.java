package com.ccb.controller;

import com.ccb.domain.common.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 登录接口
 * @Author: CCB
 * @Date: 2023/2/8 16:14
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "登录接口")
public class LoginController {

    @ApiOperation("登录")
    @GetMapping("/test")
    @ResponseBody
    public ResultInfo<Boolean> test() {
        return ResultInfo.success(Boolean.TRUE);
    }
}
