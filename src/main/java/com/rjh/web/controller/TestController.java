package com.rjh.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author Null
 * @date 2019-12-10
 */
@RestController
@RequestMapping("test")
public class TestController {
    /**
     * 不支持String类型的返回值<br/>
     * 因为SpringMVC会自动将String类型返回值的方法标记Content-Type为text/plain<br/>
     * 导致后续无法转化为json，直接抛出异常
     * @param str
     * @return
     */
    @GetMapping("string/{str}")
    public String testString(@PathVariable(required = false) String str){
        return str;
    }

    @GetMapping("Boolean")
    public Boolean testBoolean(){
        return true;
    }

    @GetMapping("int")
    public int testInt(){
        return 1;
    }
}
