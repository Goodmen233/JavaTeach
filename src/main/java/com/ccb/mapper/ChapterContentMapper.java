package com.ccb.mapper;

import com.ccb.basemapper.BaseMapper;
import com.ccb.domain.po.ChapterContentPO;

/**
 * @Description: 章节内容Mapper
 * @Author: CCB
 * @Date: 2023/2/20 16:57
 */
public interface ChapterContentMapper extends BaseMapper<ChapterContentPO> {

    /**
     * 根据章节id获取章节内容
     *
     * @param chapterId
     * @return
     */
    ChapterContentPO queryChapterContentByChapterId(Long chapterId);
}
