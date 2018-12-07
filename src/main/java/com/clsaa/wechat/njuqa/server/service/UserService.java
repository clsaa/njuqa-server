package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.wechat.njuqa.server.dao.UserDao;
import com.clsaa.wechat.njuqa.server.model.po.User;
import com.clsaa.wechat.njuqa.server.model.vo.UserV1;
import com.clsaa.wechat.njuqa.server.util.BeanUtils;
import com.clsaa.wechat.njuqa.server.util.TimestampUtil;
import com.clsaa.wechat.njuqa.server.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author joyren
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserV1 addUser(String id, String username, String nickname, String avatarUrl, String type) {
        User user = new User();
        user.setId(UUIDUtil.getUUID());
        user.setUsername(username);
        user.setNickname(nickname);
        user.setAvatarUrl(avatarUrl);
        user.setType("ADMIN");
        user.setCtime(TimestampUtil.now());
        user.setMtime(TimestampUtil.now());
        user.setStatus("DELETED");
        this.userDao.save(user);
        return BeanUtils.convertType(user, UserV1.class);
    }

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
        user.setMtime(TimestampUtil.now());
        this.userDao.save(user);
        return BeanUtils.convertType(user, UserV1.class);
    }

}
