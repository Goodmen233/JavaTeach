package com.ccb.service;

import com.ccb.domain.bo.AuditBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.UserPO;
import com.ccb.domain.vo.resp.audit.AuditDetailResp;

/**
 * @Description: 审核服务
 * @Author: CCB
 * @Date: 2023/4/3 20:51
 */
public interface AuditService {

    /**
     * 查询审核人列表
     *
     * @param auditBO
     * @return
     */
    PageResp<UserPO> queryUser(AuditBO auditBO);

    /**
     * 查询审核详情
     *
     * @param id
     * @return
     */
    AuditDetailResp queryUserDetailById(Long id);

    /**
     * 审核通过
     *
     * @param id
     * @param status
     */
    void audit(Long id, Integer status);

}
