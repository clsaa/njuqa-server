package com.clsaa.wechat.njuqa.server.controller;

import com.clsaa.wechat.njuqa.server.model.dto.UserDtoV1;
import com.clsaa.wechat.njuqa.server.model.vo.UserV1;
import com.clsaa.wechat.njuqa.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author joyren
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * <p>
     * 根据用户id查询单个用户
     * </p>
     *
     * @param id 用户id
     * @return {@link UserV1}
     * @summary 根据id查询用户
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-07
     */
    @GetMapping(value = "/v1/user/{id}")
    public UserV1 findUserByIdV1(@PathVariable("id") String id) {
        return this.userService.findUserV1ById(id);
    }

    /**
     * <p>
     * 修改用户信息
     * </p>
     *
     * @param userDtoV1 user传输层对象（JSON）
     * @return {@link UserV1}
     * @summary 修改用户信息
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-07
     */
    @PutMapping(value = "/v1/user/{id}")
    public UserV1 updateUserByIdV1(@RequestBody UserDtoV1 userDtoV1) {
        return this.userService.updateUser(userDtoV1.getId(),
                userDtoV1.getUsername(),
                userDtoV1.getNickname(),
                userDtoV1.getAvatarUrl(),
                userDtoV1.getType());
    }
}
