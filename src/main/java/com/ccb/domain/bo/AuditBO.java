package com.ccb.domain.bo;

import com.ccb.domain.common.PageBO;
import lombok.Data;

/**
 * @Description: 审核BO
 * @Author: CCB
 * @Date: 2023/4/3 20:44
 */
@Data
public class AuditBO extends PageBO {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否审核学生标记
     */
    private Boolean isAuditStudent;
}
