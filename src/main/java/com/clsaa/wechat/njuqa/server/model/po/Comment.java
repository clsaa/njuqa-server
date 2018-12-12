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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public Timestamp getMtime() {
        return mtime;
    }

    public void setMtime(Timestamp mtime) {
        this.mtime = mtime;
    }
}
