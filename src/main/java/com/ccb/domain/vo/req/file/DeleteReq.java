package com.ccb.domain.vo.req.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 文件删除入参
 * @Author: CCB
 * @Date: 2023/2/10 18:25
 */
@Data
@ApiModel("文件删除入参")
public class DeleteReq {

    @ApiModelProperty("文件id")
    private Long id;

}
