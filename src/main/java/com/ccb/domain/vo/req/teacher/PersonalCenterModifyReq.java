package com.ccb.domain.vo.req.teacher;

import com.ccb.domain.common.CommonReq;
import com.ccb.domain.po.ClassPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 教师个人中心修改入参
 * @Author: CCB
 * @Date: 2023/2/10 10:33
 */
@Data
@ApiModel("教师个人中心修改入参")
public class PersonalCenterModifyReq extends CommonReq {

    @ApiModelProperty("教师id")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("头像id")
    private Long avatarId;

    @ApiModelProperty("头像url")
    private String avatarUrl;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("介绍")
    private String introduce;

    @ApiModelProperty("研究方向")
    private String researchDirections;

    @ApiModelProperty("管理的班级集合")
    private List<Long> classIdList;
}
