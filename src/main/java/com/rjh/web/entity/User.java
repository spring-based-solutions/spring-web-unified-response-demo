package com.rjh.web.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户类
 * @author NULL
 * @date 2019-07-16
 */
@ApiModel(value="User用户")
@Data
@EqualsAndHashCode
public class User implements Serializable {

    @ApiModelProperty(value="用户ID",example="1")
    private Integer id;

    @ApiModelProperty(value="用户名",example = "Ben")
    private String name;
    
}
