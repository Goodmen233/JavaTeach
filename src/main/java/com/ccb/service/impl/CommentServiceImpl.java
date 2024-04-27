package com.ccb.service.impl;

import com.ccb.domain.bo.CommentBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.CommentPO;
import com.ccb.mapper.CommentMapper;
import com.ccb.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description: 评论服务实现
 * @Author: CCB
 * @Date: 2023/4/3 18:41
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public PageResp<CommentPO> queryComment(CommentBO commentBO) {
        PageResp<CommentPO> page = new PageResp<>();
        page.setTotal(commentMapper.countComment(commentBO));
        page.setRows(commentMapper.queryComment(commentBO));
        return page;
    }

    @Override
    public void insertComment(CommentPO commentPO) {
        commentMapper.insertSelective(commentPO);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentMapper.deleteByPrimaryKey(id);
    }
}
