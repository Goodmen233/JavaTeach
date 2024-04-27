package com.ccb.domain.bo;

import com.ccb.domain.common.PageBO;
import lombok.Data;

/**
 * @Description: 文件BO
 * @Author: CCB
 * @Date: 2023/3/29 09:50
 */
@Data
public class FileBO extends PageBO {

    /**
     * 文件id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 关联id
     */
    private Long linkId;

    /**
     * 关联类型 0:人物头像 1:课程封面 2:章节内容 3:关联课程(资料)
     */
    private Integer linkType;
}
