package com.clsaa.wechat.njuqa.server.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author joyren
 */
@Getter
@Setter
public class UserAttentionV1 {
    private String id;
    private String sourceUser;
    private String targetUser;
    private Timestamp ctime;
    private Timestamp mtime;
}
