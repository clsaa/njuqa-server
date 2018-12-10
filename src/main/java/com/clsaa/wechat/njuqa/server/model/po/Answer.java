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
@Table(name = "t_answer", schema = "db_njuqa",
        indexes = {@Index(columnList = "user_id,question_id", unique = true)})
public class Answer {

    public static final String TYPE_ANONYMOUS = "ANONYMOUS";
    public static final String TYPE_SHOW = "SHOW";

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "user_id")
    private String userId;

    @Basic
    @Column(name = "question_id")
    private String questionId;

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
    @Column(name = "type")
    private String type;
}
