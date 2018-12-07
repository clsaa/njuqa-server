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
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "username")
    private String username;
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
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "status")
    private String status;
}
