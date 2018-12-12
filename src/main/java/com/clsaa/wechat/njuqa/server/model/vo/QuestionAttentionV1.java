package com.clsaa.wechat.njuqa.server.model.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
public class QuestionAttentionV1 {

    private String id;
    private String userId;
    private String questionId;
    private Timestamp ctime;
    private Timestamp mtime;
}
