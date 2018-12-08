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
@Table(name = "t_comment", schema = "db_njuqa")
public class Comment {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "user_id")
    private String userId;

    @Basic
    @Column(name = "answer_id")
    private String answerId;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "ctime")
    private Timestamp ctime;

    @Basic
    @Column(name = "mtime")
    private Timestamp mtime;
}
