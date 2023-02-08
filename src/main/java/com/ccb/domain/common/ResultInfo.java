package com.ccb.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 通用返回结果
 * @Author: CCB
 * @Date: 2023/2/7 14:38
 */
@Data
@NoArgsConstructor
@ApiModel(value = "通用返回结果")
public class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = 6059987044671962617L;

    /**
     * 应答结果状态码——成功
     */
    public static final int RESULT_CODE_SUCCESS = 0;

    /**
     * 应答结果状态码—通用错误
     */
    public static final int RESULT_CODE_COMMON_ERR = 9999;

    /**
     * 返回状态，默认0成功
     */
    @ApiModelProperty(value = "返回状态")
    private int status = RESULT_CODE_SUCCESS;

    /**
     * 返回状态描述
     */
    @ApiModelProperty(value = "返回状态描述")
    private String statusInfo = "SUCCESS";

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;


    /**
     * 返回一个默认的错误结果
     * @return 错误结果
     */
    public static ResultInfo error() {
        ResultInfo res = new ResultInfo(RESULT_CODE_COMMON_ERR, "ERROR");
        return res;
    }

    /**
     * 返回一个带错误信息的错误结果
     * @param errorMessage 错误信息
     * @return 错误结果
     */
    public static <T> ResultInfo<T> errorMessage(String errorMessage) {
        ResultInfo res = new ResultInfo(RESULT_CODE_COMMON_ERR, errorMessage);
        return res;
    }

    /**
     * 返回一个带错误信息、自定义错误编码的错误结果
     * @param status
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> ResultInfo<T> errorMessage(int status,String errorMessage){
        ResultInfo res = new ResultInfo(status, errorMessage);
        return res;
    }

    /**
     * 返回一个带错误信息和数据的错误结果
     * @param errorMessage 错误信息
     * @param data 数据
     * @return 错误结果
     */
    public static <T> ResultInfo<T> errorMessage(String errorMessage, Object data) {
        ResultInfo res = new ResultInfo(RESULT_CODE_COMMON_ERR, errorMessage);
        res.setData(data);
        return res;
    }

    /**
     * 返回一个带状态和信息的结果
     * @param status 状态
     * @param info 信息
     * @return 返回结果
     */
    public static <T> ResultInfo<T> result(int status, String info) {
        ResultInfo res = new ResultInfo();
        res.status = status;
        res.statusInfo = info;
        return res;
    }

    /**
     * 返回一个带状态,信息和数据的结果
     * @param status 状态
     * @param info 信息
     * @param data 数据
     * @return 返回结果
     */
    public static <T> ResultInfo<T> result(int status, String info, Object data) {
        ResultInfo res = new ResultInfo();
        res.status = status;
        res.statusInfo = info;
        res.data = data;
        return res;
    }

    /**
     * 返回一个成功结果
     * @return 成功结果
     */
    public static <T> ResultInfo<T> success() {
        ResultInfo res = new ResultInfo();
        return res;
    }

    /**
     * 返回一个带数据的成功结果
     * @param data 数据
     * @return 成功结果
     */
    public static <T> ResultInfo<T> success(Object data) {
        ResultInfo res = new ResultInfo();
        res.setData(data);
        return res;
    }

    /**
     * 返回一个带信息的成功结果
     * @param message 提示信息
     * @return 成功结果
     */
    public static <T> ResultInfo<T> successMessage(String message) {
        ResultInfo res = new ResultInfo(RESULT_CODE_SUCCESS, message);
        return res;
    }

    /**
     * 带状态和信息的构造函数
     * @param status 状态
     * @param statusInfo 提示信息
     */
    public ResultInfo(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }
}
