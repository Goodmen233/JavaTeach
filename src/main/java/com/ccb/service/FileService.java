package com.ccb.service;

import com.ccb.domain.bo.FileBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.FilePO;

/**
 * @Description: 文件服务
 * @Author: CCB
 * @Date: 2023/3/29 09:40
 */
public interface FileService {

    /**
     * 查询文件
     *
     * @param fileBO
     * @return
     */
    PageResp<FilePO> queryFile(FileBO fileBO);

}
