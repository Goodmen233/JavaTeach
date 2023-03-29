package com.ccb.mapper;

import com.ccb.domain.bo.ForumBO;
import com.ccb.domain.po.ForumPO;

import java.util.List;

/**
 * @Description: 讨论Mapper
 * @Author: CCB
 * @Date: 2023/2/20 16:56
 */
public interface ForumMapper extends BaseMapper<ForumPO> {

    /**
     * 查询讨论
     *
     * @param forumBO
     * @return
     */
    List<ForumPO> queryForum(ForumBO forumBO);

    /**
     * 统计讨论
     *
     * @param forumBO
     * @return
     */
    Long countForum(ForumBO forumBO);
}
