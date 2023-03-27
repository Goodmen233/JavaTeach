package com.ccb.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.ccb.common.annotations.MethodLog;
import com.ccb.common.constants.RedisConstant;
import com.ccb.common.urls.CommonUrl;
import com.ccb.common.utils.RedisUtil;
import com.ccb.context.ApplicationContext;
import com.ccb.domain.bo.User;
import com.ccb.domain.common.ResultInfo;
import com.ccb.exception.BizException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 通用接口
 * @Author: CCB
 * @Date: 2023/2/10 10:28
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "通用接口")
public class CommonController {

    @MethodLog
    @ApiOperation("生成验证码")
    @PostMapping(CommonUrl.CAPTCHA)
    @ResponseBody
    public ResultInfo<String> captcha() {
        User user = ApplicationContext.getUser();
        if (Objects.isNull(user)) {
            throw new BizException("未查询到用户登录信息");
        }
        String key = RedisConstant.CAPTCHA_KEY + user.getPhone();
        if (RedisUtil.containsValueKey(key)) {
            throw new BizException("获取验证码太过频繁");
        }
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(300, 100, 4, 4);
        //获取到4位数的验证码
        String code = shearCaptcha.getCode();
        // 放入redis
        RedisUtil.cacheValue(key, code, 5, TimeUnit.MINUTES);
        return ResultInfo.success(code);
    }
}
