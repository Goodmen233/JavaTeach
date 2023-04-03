package com.ccb.domain.bo;

import com.ccb.common.enums.CommentLinkTypeEnum;
import com.ccb.domain.common.PageBO;
import lombok.Data;

/**
 * @Description: 评论BO
 * @Author: CCB
 * @Date: 2023/4/3 18:37
 */
@Data
public class CommentBO extends PageBO {

    /**
     * 关联id
     */
    private Long linkId;

    /**
     * 关联类型 {@link CommentLinkTypeEnum}
     */
    private Integer linkType;
}
