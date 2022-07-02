package com.rjh.web.controller;

import com.rjh.web.entity.User;
import com.rjh.web.exception.BaseException;
import com.rjh.web.response.ResponseCode;
import com.rjh.web.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示用的Controller
 * @author NULL
 * @date 2019-07-16
 */
@Api(tags="用户控制器")
@RestController
@RequestMapping("users")
public class UserController {
    /**
     * 当前ID
     */
    private AtomicInteger currentId=new AtomicInteger(1);
    /**
     * 用户列表
     */
    private Map<Integer,User> users=new ConcurrentHashMap<>();

    /**
     * 根据用户ID获取用户
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(value = "根据用户ID查询用户信息")
    @GetMapping("user")
    public User getUserById(@RequestParam(name = "userId") Integer userId){
        if(users.containsKey(userId)){
            return users.get(userId);
        }else{
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }

    /**
     * 列出所有用户
     * @return
     */
    @ApiOperation(value = "用户列表查询")
    @GetMapping
    public Collection<User> listAllUsers(){
        return users.values();
    }

    /**
     * 新增用户
     * @param user 用户实体
     * @return
     */
    @ApiOperation(value = "新增用户")
    @PostMapping
    public User addUser(@RequestBody User user){
        user.setId(currentId.getAndIncrement());
        users.put(user.getId(),user);
        return user;
    }

    /**
     * 更新用户信息
     * @param userId
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户信息")
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId,@RequestBody User user){
        if(users.containsKey(userId)){
           User newUser=users.get(userId);
           newUser.setName(user.getName());
           return newUser;
        }else{
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }

    /**
     * 删除用户
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(value = "根据用户ID删除用户")
    @DeleteMapping("/{userId}")
    public Boolean deleteUserById(@PathVariable Integer userId){
        users.remove(userId);
        return true;
    }

}
