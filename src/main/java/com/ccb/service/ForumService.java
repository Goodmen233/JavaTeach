package com.ccb.service;

import com.ccb.domain.bo.ForumBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.ForumPO;

/**
 * @Description: 讨论服务
 * @Author: CCB
 * @Date: 2023/3/29 14:09
 */
public interface ForumService {

    /**
     * 查询讨论
     *
     * @param forumBO
     * @return
     */
    PageResp<ForumPO> queryForum(ForumBO forumBO);

    /**
     * 新增讨论
     *
     * @param forumPO
     */
    void insertForum(ForumPO forumPO);

    /**
     * 删除讨论
     *
     * @param id
     */
    void deleteFormById(Long id);
}
