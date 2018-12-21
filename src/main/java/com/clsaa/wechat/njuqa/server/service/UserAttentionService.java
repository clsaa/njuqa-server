package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.rest.result.bizassert.BizAssert;
import com.clsaa.wechat.njuqa.server.config.BizCodes;
import com.clsaa.wechat.njuqa.server.dao.UserAttentionDao;
import com.clsaa.wechat.njuqa.server.model.po.UserAttention;
import com.clsaa.wechat.njuqa.server.model.vo.UserAttentionV1;
import com.clsaa.wechat.njuqa.server.util.BeanUtils;
import com.clsaa.wechat.njuqa.server.util.TimestampUtil;
import com.clsaa.wechat.njuqa.server.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户关注业务实现
 *
 * @author joyren
 */
@Service
public class UserAttentionService {
    @Autowired
    private UserAttentionDao userAttentionDao;

    public UserAttentionV1 addUserAttention(String sourceUser, String targetUser) {
        UserAttention exitUserAttention = this.userAttentionDao.findUserAttentionBySourceUserAndTargetUser(sourceUser, targetUser);
        BizAssert.allowed(exitUserAttention == null, BizCodes.REPEATED_USER_ATTENTION);
        UserAttention userAttention = new UserAttention();
        userAttention.setId(UUIDUtil.getUUID());
        userAttention.setSourceUser(sourceUser);
        userAttention.setTargetUser(targetUser);
        userAttention.setCtime(TimestampUtil.now());
        userAttention.setMtime(TimestampUtil.now());
        return BeanUtils.convertType(this.userAttentionDao.saveAndFlush(userAttention), UserAttentionV1.class);
    }

    public boolean deleteUserAttentionBySourceAndTargetUser(String sourceUser, String targetUser) {
        UserAttention exitUserAttention = this.userAttentionDao.findUserAttentionBySourceUserAndTargetUser(sourceUser, targetUser);
        BizAssert.found(exitUserAttention != null, BizCodes.NOT_FOUND);
        this.userAttentionDao.delete(exitUserAttention);
        return true;
    }

    public UserAttentionV1 findUserAttentionBySourceUserAndTargetUser(String sourceUser, String targetUser) {
        UserAttention exitUserAttention = this.userAttentionDao.findUserAttentionBySourceUserAndTargetUser(sourceUser, targetUser);
        if (exitUserAttention == null) {
            return null;
        } else {
            return BeanUtils.convertType(exitUserAttention, UserAttentionV1.class);
        }
    }
}
