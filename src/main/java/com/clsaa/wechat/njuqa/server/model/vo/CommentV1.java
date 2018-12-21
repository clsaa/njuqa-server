package com.clsaa.wechat.njuqa.server.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author joyren
 */
@Getter
@Setter
public class CommentV1 {
    private String id;
    private String userId;
    private String answerId;
    private String content;
    private Timestamp ctime;
    private Timestamp mtime;
    private UserV1 userV1;
}
