package com.clsaa.wechat.njuqa.server.dao;

import com.clsaa.wechat.njuqa.server.model.po.UserAttention;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户关注持久层
 *
 * @author joyren
 */
public interface UserAttentionDao extends JpaRepository<UserAttention, String> {

    /**
     * 根据源用户和目标用户id查询关系是否存在
     *
     * @param sourceUser 源用户
     * @param targetUser 被关注用户
     * @return {@link UserAttention}
     */
    UserAttention findUserAttentionBySourceUserAndTargetUser(String sourceUser, String targetUser);
}
