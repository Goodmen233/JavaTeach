package com.ccb.service;

import com.ccb.domain.bo.User;
import com.ccb.domain.vo.req.user.LoginReq;
import com.ccb.domain.vo.req.user.RegisterReq;
import com.ccb.domain.vo.req.user.RegisterSubmitReq;
import com.ccb.domain.vo.req.user.UpdatePasswordReq;
import com.ccb.domain.vo.resp.user.LoginResp;
import com.ccb.domain.vo.resp.user.RegisterResp;

/**
 * @Description: 用户
 * @Author: CCB
 * @Date: 2023/2/20 18:35
 */
public interface UserService {

    /**
     * 登录
     *
     * @param loginReq 登录信息
     * @return 登录结果
     */
    LoginResp login(LoginReq loginReq);

    /**
     * 获取注册信息
     *
     * @param registerReq 注册凭证
     * @return 注册信息
     */
    RegisterResp registerInfo(RegisterReq registerReq);

    /**
     * 注册信息提交
     *
     * @param registerSubmitReq 注册信息
     * @return 提交成功返回true，反之返回false
     */
    Boolean registerSubmit(RegisterSubmitReq registerSubmitReq);

    /**
     * 修改密码
     *
     * @param updatePasswordReq 修改密码凭证
     * @return 修改成功返回true，反之返回false
     */
    Boolean updatePassword(UpdatePasswordReq updatePasswordReq);

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    User queryUserById(Long id);
}
