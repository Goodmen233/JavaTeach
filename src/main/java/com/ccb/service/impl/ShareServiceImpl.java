package com.ccb.service.impl;

import com.ccb.domain.bo.ShareBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.SharePO;
import com.ccb.mapper.ShareMapper;
import com.ccb.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description: 分享服务实现
 * @Author: CCB
 * @Date: 2023/4/3 18:29
 */
@Service
@RequiredArgsConstructor
public class ShareServiceImpl implements ShareService {

    private final ShareMapper shareMapper;

    @Override
    public PageResp<SharePO> queryShare(ShareBO shareBO) {
        PageResp<SharePO> page = new PageResp<>();
        page.setRows(shareMapper.queryShare(shareBO));
        page.setTotal(shareMapper.countShare(shareBO));
        return page;
    }
}
