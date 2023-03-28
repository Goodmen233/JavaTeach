package com.ccb.service;

import com.ccb.domain.po.ChapterContentPO;
import com.ccb.domain.vo.resp.user.ChapterTreeResp;

/**
 * @Description: 章节服务
 * @Author: CCB
 * @Date: 2023/3/27 15:46
 */
public interface ChapterService {

    /**
     * 查询章节树
     *
     * @param courseId
     * @return
     */
    ChapterTreeResp queryChapterTree(Long courseId);

    /**
     * 查询章节内容
     *
     * @param chapterId
     * @return
     */
    ChapterContentPO queryChapterContentByChapterId(Long chapterId);
}
