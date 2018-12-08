package com.clsaa.wechat.njuqa.server.model.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author joyren
 */
@Getter
@Setter
@Entity
@Table(name = "t_question_attention", schema = "db_njuqa")
public class QuestionAttention {

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
