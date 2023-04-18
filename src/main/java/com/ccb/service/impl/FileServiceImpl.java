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
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        Example example = new Example(FilePO.class);
        example.clear();
        example.createCriteria()
                .andEqualTo("linkId", userId)
                .andEqualTo("linkType", FileLinkTypeEnum.USER_AVATAR.getIndex());
        List<FilePO> filePOS = fileMapper.selectByExample(example);
        if (CollectionUtil.isSingleElement(filePOS)) {
            return filePOS.get(0);
        } else if (CollectionUtil.isEmpty(filePOS)) {
            return new FilePO();
        } else {
            throw new BizException("查询用户头像异常");
        }
    }

    @Override
    public Long saveFile(FilePO filePO) {
        if (Objects.isNull(filePO.getId())) {
            fileMapper.insertSelective(filePO);
        } else {
            fileMapper.updateByPrimaryKey(filePO);
        }
        return filePO.getId();
    }

    @Override
    public void deleteFileById(Long id) {
        fileMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFile(List<FilePO> fileList, Long linkId) {
        List<Integer> linkTypeList = fileList.stream().map(FilePO::getLinkType).distinct().collect(Collectors.toList());
        Example example = new Example(FilePO.class);
        example.clear();
        example.createCriteria()
                .andEqualTo("linkId", linkId)
                .andIn("linkType", linkTypeList);
        fileMapper.deleteByExample(example);
        fileList.forEach(t -> {
            t.setLinkId(linkId);
        });
        fileMapper.insertList(fileList);
    }
}
