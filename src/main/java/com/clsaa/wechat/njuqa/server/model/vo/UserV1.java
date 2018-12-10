package com.clsaa.wechat.njuqa.server.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


/**
 * @author joyren
 */
@Getter
@Setter
public class UserV1 {
    private String id;
    private String openId;
    private String nickname;
    private String avatarUrl;
    private Timestamp ctime;
    private Timestamp mtime;
    private String identity;
}
