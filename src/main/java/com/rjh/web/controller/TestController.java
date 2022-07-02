package com.rjh.web.controller;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author Null
 * @date 2019-12-10
 */
@Api(tags="测试控制器")
@RestController
@RequestMapping("test")
public class TestController {

    @ApiOperation("测试字符串返回")
    @ApiParam(type = "path",example = "test",value = "测试字符串")
    @GetMapping("string/{str}")
    public String testString(@PathVariable String str){
        return str;
    }

    @ApiOperation("测试布尔值返回")
    @GetMapping("boolean")
    public Boolean testBoolean(){
        return true;
    }

    @ApiOperation("测试整树值返回")
    @GetMapping("int")
    public int testInt(){
        return 1;
    }

}
