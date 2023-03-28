package com.ccb.service.impl;

import com.ccb.domain.po.ChapterContentPO;
import com.ccb.domain.po.ChapterPO;
import com.ccb.domain.vo.req.teacher.ChapterContentModifyReq;
import com.ccb.domain.vo.resp.user.ChapterTreeResp;
import com.ccb.mapper.ChapterContentMapper;
import com.ccb.mapper.ChapterMapper;
import com.ccb.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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
}
