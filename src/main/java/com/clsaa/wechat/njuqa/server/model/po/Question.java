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
@Table(name = "t_question", schema = "db_njuqa")
public class Question {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "user_id")
    private String userId;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "ctime")
    private Timestamp ctime;

    @Basic
    @Column(name = "mtime")
    private Timestamp mtime;

    @Basic
    @Column(name = "close_status")
    private String closeStatus;

    @Basic
    @Column(name = "delete_status")
    private String deleteStatus;

}
