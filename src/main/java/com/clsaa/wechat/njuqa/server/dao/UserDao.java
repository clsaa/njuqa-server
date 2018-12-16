package com.clsaa.wechat.njuqa.server.dao;

import com.clsaa.wechat.njuqa.server.model.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joyren
 */
public interface UserDao extends JpaRepository<User, String> {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return {@link User}
     */
    User findUsersById(String id);

    /**
     * 根据openid查询用户
     *
     * @param openId 第三方平台openid
     * @return {@link User}
     */
    User findByOpenId(String openId);


    User findUsersByNickname(String nickname);
}
