package com.ccb.service.impl;

import com.ccb.common.enums.FileLinkTypeEnum;
import com.ccb.common.utils.CollectionUtil;
import com.ccb.domain.bo.FileBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.FilePO;
import com.ccb.exception.BizException;
import com.ccb.mapper.FileMapper;
import com.ccb.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 文件服务实现
 * @Author: CCB
 * @Date: 2023/3/29 09:43
 */
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileMapper fileMapper;

    @Override
    public PageResp<FilePO> queryFile(FileBO fileBO) {
        PageResp<FilePO> page = new PageResp<>();
        page.setRows(fileMapper.queryFile(fileBO));
        page.setTotal(fileMapper.countFile(fileBO));
        return page;
    }

    @Override
    public FilePO queryAvatar(Long userId) {
        FileBO fileBO = new FileBO();
        fileBO.setLinkId(userId);
        fileBO.setLinkType(FileLinkTypeEnum.USER_AVATAR.getIndex());
        List<FilePO> filePOS = fileMapper.queryFile(fileBO);
        if (CollectionUtil.isSingleElement(filePOS)) {
            return filePOS.get(0);
        } else {
            throw new BizException("查询用户头像异常");
        }
    }
}
