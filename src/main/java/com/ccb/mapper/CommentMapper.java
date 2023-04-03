package com.ccb.mapper;

import com.ccb.domain.bo.CommentBO;
import com.ccb.domain.po.CommentPO;

import java.util.List;

/**
 * @Description: 评论Mapper
 * @Author: CCB
 * @Date: 2023/2/20 17:06
 */
public interface CommentMapper extends BaseMapper<CommentPO> {

    /**
     * 查询评论
     * @param commentBO
     * @return
     */
    List<CommentPO> queryComment(CommentBO commentBO);

    /**
     * 统计评论
     * @param commentBO
     * @return
     */
    Long countComment(CommentBO commentBO);
}
