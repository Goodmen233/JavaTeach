package com.ccb.domain.vo.req.file;

import com.ccb.common.enums.FileLinkTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件上传入参
 * @Author: CCB
 * @Date: 2023/2/10 18:24
 */
@Data
@ApiModel("文件上传入参")
public class UploadReq {

    @ApiModelProperty("文件id")
    private Long id;

    @ApiModelProperty("文件")
    private MultipartFile file;

    @ApiModelProperty("关联id")
    private Long linkId;

    @ApiModelProperty("关联类型: " + FileLinkTypeEnum.KEY_VALUE)
    private Integer linkType;
}
