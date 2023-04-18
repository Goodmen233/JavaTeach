package com.ccb.mapper;

import com.ccb.basemapper.BaseMapper;
import com.ccb.domain.po.ChapterPO;

import java.util.List;

/**
 * @Description: 章节Mapper
 * @Author: CCB
 * @Date: 2023/2/20 16:51
 */
public interface ChapterMapper extends BaseMapper<ChapterPO> {

    /**
     * 查询章节信息
     *
     * @param chapterPO
     * @return
     */
    List<ChapterPO> queryChapter(ChapterPO chapterPO);
}
