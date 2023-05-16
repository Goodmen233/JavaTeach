package com.ccb.domain.vo.req.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: CK文件上传入参
 * @Author: CCB
 * @Date: 2023/2/10 18:24
 */
@Data
@ApiModel("文件上传入参")
public class CkUploadReq {

    @ApiModelProperty("文件base64编码")
    private String upload;

    @ApiModelProperty("ckCsrfToken")
    private String ckCsrfToken;
}
