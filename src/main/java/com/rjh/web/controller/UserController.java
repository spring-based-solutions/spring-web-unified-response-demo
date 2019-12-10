package com.rjh.web.controller;

import com.rjh.web.entity.User;
import com.rjh.web.exception.BaseException;
import com.rjh.web.response.ResponseCode;
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
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
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
    @GetMapping
    public Collection<User> listAllUsers(){
        return users.values();
    }

    /**
     * 新增用户
     * @param user 用户实体
     * @return
     */
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
    @DeleteMapping("/{userId}")
    public User deleteUserById(@PathVariable Integer userId){
        User user=users.remove(userId);
        if(user!=null){
            return user;
        }else{
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }

}
