package com.ccb.mapper;

import com.ccb.domain.bo.FileBO;
import com.ccb.domain.po.FilePO;

import java.util.List;

/**
 * @Description: 文件Mapper
 * @Author: CCB
 * @Date: 2023/2/20 16:55
 */
public interface FileMapper extends BaseMapper<FilePO> {

    /**
     * 查询文件
     *
     * @param fileBO
     * @return
     */
    List<FilePO> queryFile(FileBO fileBO);

    /**
     * 统计文件
     *
     * @param fileBO
     * @return
     */
    Long countFile(FileBO fileBO);
}
