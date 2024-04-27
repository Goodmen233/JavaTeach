package com.ccb.service;

import com.ccb.domain.bo.FileBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.FilePO;

import java.util.List;

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

    /**
     * 查询用户头像
     *
     * @param userId
     * @return
     */
    FilePO queryAvatar(Long userId);

    /**
     * 保存文件信息
     *
     * @param filePO
     * @return
     */
    Long saveFile(FilePO filePO);

    /**
     * 通过主键删除id
     *
     * @param id
     */
    void deleteFileById(Long id);

    /**
     * 保存文件集合
     *
     * @param fileList
     * @param linkId
     */
    void saveFile(List<FilePO> fileList, Long linkId);

}
