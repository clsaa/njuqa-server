package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.rest.result.Pagination;
import com.clsaa.rest.result.bizassert.BizAssert;
import com.clsaa.wechat.njuqa.server.config.BizCodes;
import com.clsaa.wechat.njuqa.server.dao.UserDao;
import com.clsaa.wechat.njuqa.server.model.po.User;
import com.clsaa.wechat.njuqa.server.model.vo.UserV1;
import com.clsaa.wechat.njuqa.server.util.BeanUtils;
import com.clsaa.wechat.njuqa.server.util.TimestampUtil;
import com.clsaa.wechat.njuqa.server.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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
        user.setCtime(TimestampUtil.now());
        user.setMtime(TimestampUtil.now());
        User u = this.userDao.saveAndFlush(user);
        return BeanUtils.convertType(u, UserV1.class);
    }

    public boolean deleteUserById(String id) {
        User existUser = this.userDao.findUsersById(id);
        BizAssert.found(existUser != null, BizCodes.NOT_FOUND);
        this.userDao.delete(existUser);
        return true;
    }

    public UserV1 updateUser(String id, String username, String nickname, String avatarUrl, String type) {
        User existUser = this.userDao.findUsersById(id);
        BizAssert.found(existUser != null, BizCodes.NOT_FOUND);
        existUser.setUsername(username);
        existUser.setNickname(nickname);
        existUser.setAvatarUrl(avatarUrl);
        existUser.setMtime(TimestampUtil.now());
        existUser = this.userDao.save(existUser);
        return BeanUtils.convertType(existUser, UserV1.class);
    }

    public UserV1 findUserV1ById(String id) {
        User existUser = this.userDao.findUsersById(id);
        BizAssert.found(existUser != null, BizCodes.NOT_FOUND);
        return BeanUtils.convertType(existUser, UserV1.class);
    }

    public Pagination<UserV1> getUserV1Pagination(Integer pageNo, Integer pageSize) {
        int count = (int) this.userDao.count();

        Pagination<UserV1> pagination = new Pagination<>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        pagination.setTotalCount(count);

        if (count == 0) {
            pagination.setPageList(Collections.emptyList());
            return pagination;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "ctime");
        Pageable pageRequest = PageRequest.of(pagination.getPageNo()-1, pagination.getPageSize(), sort);
        List<User> userList = this.userDao.findAll(pageRequest).getContent();
        pagination.setPageList(userList.stream().map(u -> BeanUtils.convertType(u, UserV1.class)).collect(Collectors.toList()));
        return pagination;
    }
}
