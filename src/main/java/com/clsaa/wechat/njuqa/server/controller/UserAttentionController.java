package com.clsaa.wechat.njuqa.server.controller;

import com.clsaa.wechat.njuqa.server.model.dto.UserAttentionDtoV1;
import com.clsaa.wechat.njuqa.server.model.vo.UserAttentionV1;
import com.clsaa.wechat.njuqa.server.service.UserAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户关注接口类
 *
 * @author joyren
 */
@RestController
@CrossOrigin
public class UserAttentionController {
    @Autowired
    private UserAttentionService userAttentionService;

    /**
     * <p>
     * 添加用户关注
     * </p>
     *
     * @param userAttentionDtoV1 {@link UserAttentionDtoV1}
     * @return {@link UserAttentionV1}
     * @summary 添加用户关注
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-11
     */
    @PostMapping("/v1/user/attention")
    public UserAttentionV1 addUserAttentionV1(@RequestBody UserAttentionDtoV1 userAttentionDtoV1) {
        return this.userAttentionService.addUserAttention(userAttentionDtoV1.getSourceUser(),
                userAttentionDtoV1.getTargetUser());
    }

    /**
     * <p>
     * 取消用户关注
     * </p>
     *
     * @param sourceUser 关注用户id
     * @param targetUser 被关注用户id
     * @return {@link boolean}
     * @summary 取消用户关注
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-11
     */
    @DeleteMapping("/v1/user/attention/source/{sourceUser}/target/{targetUser}")
    public boolean deleteUserAttentionBySourceAndTargetUserV1(@PathVariable("sourceUser") String sourceUser,
                                                              @PathVariable("targetUser") String targetUser) {
        return this.userAttentionService.deleteUserAttentionBySourceAndTargetUser(sourceUser, targetUser);
    }
}
