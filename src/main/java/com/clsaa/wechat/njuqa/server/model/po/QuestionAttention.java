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
@Table(name = "t_question_attention", schema = "db_njuqa",
        indexes = {@Index(columnList = "user_id,question_id",unique = true)})
public class QuestionAttention {

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
    @Column(name = "ctime")
    private Timestamp ctime;

    @Basic
    @Column(name = "mtime")
    private Timestamp mtime;

}
