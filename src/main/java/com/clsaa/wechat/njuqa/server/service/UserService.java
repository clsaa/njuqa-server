package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.wechat.njuqa.server.dao.UserDao;
import com.clsaa.wechat.njuqa.server.model.po.User;
import com.clsaa.wechat.njuqa.server.model.vo.UserV1;
import com.clsaa.wechat.njuqa.server.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author joyren
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserV1 findUserV1ById(String id) {
        return BeanUtils.convertType(this.userDao.findUsersById(id), UserV1.class);
    }

    public UserV1 updateUser(String id, String username, String nickname, String avatarUrl, String type) {
        User user = this.userDao.findUsersById(id);
        if (user == null) {
            return null;
        }
        user.setUsername(username);
        user.setNickname(nickname);
        user.setAvatarUrl(avatarUrl);
        user.setType(type);
        user.setMtime(new Timestamp(System.currentTimeMillis()));
        this.userDao.save(user);
        return BeanUtils.convertType(user, UserV1.class);
    }
}
