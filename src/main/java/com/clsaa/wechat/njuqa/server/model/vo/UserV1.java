package com.clsaa.wechat.njuqa.server.model.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author joyren
 */
@Getter
@Setter
public class UserV1 {
    private String id;
    private String username;
    private String nickname;
    private String avatarUrl;
    private Timestamp ctime;
    private Timestamp mtime;
    private String type;
    private String status;
}
