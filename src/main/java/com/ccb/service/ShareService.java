package com.ccb.service;

import com.ccb.domain.bo.ShareBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.SharePO;

/**
 * @Description: 分享服务
 * @Author: CCB
 * @Date: 2023/4/3 18:26
 */
public interface ShareService {

    /**
     * 查询分享
     * @param shareBO
     * @return
     */
    PageResp<SharePO> queryShare(ShareBO shareBO);
}
