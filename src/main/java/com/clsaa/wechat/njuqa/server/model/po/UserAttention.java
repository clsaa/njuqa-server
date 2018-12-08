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
@Table(name = "t_user_attention", schema = "db_njuqa",
        indexes = {@Index(columnList = "source_user,target_user", unique = true)})
public class UserAttention {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "source_user")
    private String sourceUser;

    @Basic
    @Column(name = "target_user")
    private String targetUser;

    @Basic
    @Column(name = "ctime")
    private Timestamp ctime;

    @Basic
    @Column(name = "mtime")
    private Timestamp mtime;

}
