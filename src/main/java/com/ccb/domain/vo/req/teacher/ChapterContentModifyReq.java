package com.ccb.domain.vo.req.teacher;

import com.ccb.domain.po.FilePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 章节内容新增/修改入参
 * @Author: CCB
 * @Date: 2023/2/10 10:39
 */
@Data
@ApiModel("章节内容新增修改入参")
public class ChapterContentModifyReq {

    @ApiModelProperty("课程内容id")
    private Long id;

    @ApiModelProperty("课程内容")
    private String content;

    @ApiModelProperty("章节id")
    private Long chapterId;

    @ApiModelProperty("文件集合，传文件的URL和关联类型")
    private List<FilePO> fileList;
}
