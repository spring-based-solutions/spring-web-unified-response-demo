package com.rjh.web.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一的公共响应体
 * @author NULL
 * @date 2019-07-16
 */
@ApiModel("公共响应")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {
    /**
     * 返回状态码
     */
    @ApiModelProperty("返回状态码")
    private Integer code;
    /**
     * 返回信息
     */
    @ApiModelProperty("返回信息")
    private String msg;
    /**
     * 数据
     */
    @ApiModelProperty("数据")
    private T data;

}
