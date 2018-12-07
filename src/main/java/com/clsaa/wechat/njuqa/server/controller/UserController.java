package com.clsaa.wechat.njuqa.server.controller;

import com.clsaa.rest.result.Pagination;
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
     * 添加一个用户
     * </p>
     *
     * @param userDtoV1 {@link UserDtoV1} user传输层对象（JSON）
     * @return {@link }
     * @summary 添加用户
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-07
     */
    @PostMapping(value = "/v1/user")
    public UserV1 addUserV1(@RequestBody UserDtoV1 userDtoV1) {
        return this.userService.addUser(userDtoV1.getId(),
                userDtoV1.getUsername(),
                userDtoV1.getNickname(),
                userDtoV1.getAvatarUrl(),
                userDtoV1.getType());
    }

    /**
     * <p>
     * 根据id删除用户
     * </p>
     *
     * @param id 用户id
     * @return {@link }
     * @summary 根据id删除用户
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-07
     */
    @DeleteMapping(value = "/v1/user/{id}")
    public boolean deleteUserV1(@PathVariable("id") String id) {
        return this.userService.deleteUserById(id);
    }


    /**
     * <p>
     * 修改用户信息
     * </p>
     *
     * @param userDtoV1 {@link UserDtoV1} user传输层对象（JSON）
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
     *  分页查询用户信息
     * </p>
     *
     * @param pageNo   页号，默认为1
     * @param pageSize 页大小，默认为10
     * @return {@link Pagination<UserV1>}
     * @summary 分页查询用户信息
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-07
     */
    @GetMapping(value = "/v1/user/pagination")
    public Pagination<UserV1> getUserPaginationV1(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return this.userService.getUserV1Pagination(pageNo, pageSize);
    }
}
