package com.rjh.web.controller;

import com.rjh.web.entity.User;
import com.rjh.web.exception.BaseException;
import com.rjh.web.response.BaseResponse;
import com.rjh.web.response.ResponseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用的Controller
 *
 * @author NULL
 * @date 2019-07-16
 */
@BaseResponse
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
        if(userId.equals(0)){
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
        if(userId.equals(1)){
            throw new RuntimeException();
        }
        User user=new User();
        user.setId(userId);
        user.setName("test");
        return user;
    }


}
