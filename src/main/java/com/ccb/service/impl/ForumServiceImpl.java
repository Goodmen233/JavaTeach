package com.ccb.service.impl;

import com.ccb.domain.bo.ForumBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.ForumPO;
import com.ccb.mapper.ForumMapper;
import com.ccb.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description: 讨论服务实现
 * @Author: CCB
 * @Date: 2023/3/29 14:10
 */
@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

    private final ForumMapper forumMapper;

    @Override
    public PageResp<ForumPO> queryForum(ForumBO forumBO) {
        PageResp<ForumPO> page = new PageResp<>();
        page.setTotal(forumMapper.countForum(forumBO));
        page.setRows(forumMapper.queryForum(forumBO));
        return page;
    }
}
