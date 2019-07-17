package com.rjh.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户类
 * @author NULL
 * @date 2019-07-16
 */
@Data
@EqualsAndHashCode
public class User implements Serializable {

    private Integer id;

    private String name;
    
}
