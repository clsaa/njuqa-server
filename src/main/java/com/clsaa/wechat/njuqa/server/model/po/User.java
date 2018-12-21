package com.clsaa.wechat.njuqa.server.model.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author joyren
 */
@Getter
@Setter
@Entity
@Table(name = "t_user", schema = "db_njuqa")
public class User {
    public static final String IDENTITY_SUPER_ADMIN = "ADMIN";
    public static final String IDENTITY_NORMAL_USER = "NORMAL_USER";
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "openid")
    private String openId;
    @Basic
    @Column(name = "nickname")
    private String nickname;
    @Basic
    @Column(name = "avatarUrl")
    private String avatarUrl;
    @Basic
    @Column(name = "ctime")
    private Timestamp ctime;
    @Basic
    @Column(name = "mtime")
    private Timestamp mtime;
    @Basic
    @Column(name = "identity")
    private String identity;

}
