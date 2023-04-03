package com.ccb.mapper;

import com.ccb.domain.bo.ShareBO;
import com.ccb.domain.po.SharePO;

import java.util.List;

/**
 * @Description: 分享Mapper
 * @Author: CCB
 * @Date: 2023/2/20 16:57
 */
public interface ShareMapper extends BaseMapper<SharePO> {

    /**
     * 查询分享
     * @param shareBO
     * @return
     */
    List<SharePO> queryShare(ShareBO shareBO);

    /**
     * 统计分享
     * @param shareBO
     * @return
     */
    Long countShare(ShareBO shareBO);
}
