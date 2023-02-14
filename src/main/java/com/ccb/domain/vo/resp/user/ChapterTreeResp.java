package com.ccb.domain.vo.resp.user;

import com.ccb.domain.po.ChapterPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 章节树出参
 * @Author: CCB
 * @Date: 2023/2/9 14:44
 */
@Data
@ApiModel("章节树出参")
public class ChapterTreeResp {

    @ApiModelProperty("章节树节点信息列表，按照1 -> 1.1 -> 1.1.1 -> 1.2等顺序返回")
    private List<ChapterPO> chapterTreeBOList;

}
