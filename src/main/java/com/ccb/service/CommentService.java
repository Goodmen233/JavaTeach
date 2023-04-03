package com.ccb.service;

import com.ccb.domain.bo.CommentBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.CommentPO;

/**
 * @Description: 评论服务
 * @Author: CCB
 * @Date: 2023/4/3 18:41
 */
public interface CommentService {

    /**
     * 查询评论
     *
     * @param commentBO
     * @return
     */
    PageResp<CommentPO> queryComment(CommentBO commentBO);

    /**
     * 插入评论
     *
     * @param commentPO
     */
    void insertComment(CommentPO commentPO);

    /**
     * 删除评论
     *
     * @param id
     */
    void deleteCommentById(Long id);
}
