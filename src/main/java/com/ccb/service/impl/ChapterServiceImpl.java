package com.ccb.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ccb.domain.po.ChapterContentPO;
import com.ccb.domain.po.ChapterPO;
import com.ccb.domain.vo.req.teacher.ChapterContentModifyReq;
import com.ccb.domain.vo.resp.user.ChapterTreeResp;
import com.ccb.mapper.ChapterContentMapper;
import com.ccb.mapper.ChapterMapper;
import com.ccb.service.ChapterService;
import com.ccb.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 章节服务实现
 * @Author: CCB
 * @Date: 2023/3/27 15:52
 */
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    private final ChapterContentMapper chapterContentMapper;

    private final FileService fileService;

    @Override
    public ChapterTreeResp queryChapterTree(Long courseId) {
        ChapterPO chapterPO = new ChapterPO();
        chapterPO.setCourseId(courseId);
        List<ChapterPO> chapterPOList = chapterMapper.queryChapter(chapterPO);
        // 排序 TODO 不知道对不对
        List<ChapterPO> sorted = chapterPOList.stream().sorted(Comparator.comparing(ChapterPO::getNo)).collect(Collectors.toList());
        ChapterTreeResp chapterTreeResp = new ChapterTreeResp();
        chapterTreeResp.setChapterTreePOList(sorted);
        return chapterTreeResp;
    }

    @Override
    public ChapterContentPO queryChapterContentByChapterId(Long chapterId) {
        return chapterContentMapper.queryChapterContentByChapterId(chapterId);
    }

    @Override
    public void saveChapter(ChapterPO chapterPO) {
        if (Objects.isNull(chapterPO.getId())) {
            chapterMapper.insertSelective(chapterPO);
        } else {
            chapterMapper.updateByPrimaryKey(chapterPO);
        }
    }

    @Override
    public void deleteChapterById(Long id) {
        chapterMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveChapterContent(ChapterContentModifyReq chapterContentModifyReq) {
        // 保存章节内容
        ChapterContentPO chapterContentPO = new ChapterContentPO();
        BeanUtil.copyProperties(chapterContentModifyReq, chapterContentPO);
        if (Objects.isNull(chapterContentPO.getId())) {
            chapterContentMapper.insertSelective(chapterContentPO);
        } else {
            chapterContentMapper.updateByPrimaryKey(chapterContentPO);
        }
        // 章节设置章节内容id
        Example example = new Example(ChapterPO.class);
        example.clear();
        example.createCriteria().andEqualTo("chapterContentId", chapterContentModifyReq.getChapterId());
        ChapterPO chapterPO = new ChapterPO();
        chapterPO.setChapterContentId(chapterContentPO.getId());
        chapterMapper.updateByExampleSelective(chapterPO, example);
        // 保存文件
        fileService.saveFile(chapterContentModifyReq.getFileList(), chapterContentPO.getId());
    }

    @Override
    public void deleteChapterContentById(Long id) {
        chapterContentMapper.deleteByPrimaryKey(id);
    }
}
