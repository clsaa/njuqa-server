package com.clsaa.wechat.njuqa.server.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author joyren
 */
@Getter
@Setter
public class AnswerV1 {

    private String id;
    private String userId;
    private String questionId;
    private String content;
    private Timestamp ctime;
    private Timestamp mtime;
    private String type;
    private UserV1 userV1;
}
