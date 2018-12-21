package com.clsaa.wechat.njuqa.server.model.vo;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class QuestionV1 {

    private String id;
    private String userId;
    private String content;
    private Timestamp ctime;
    private Timestamp mtime;
    private String closeStatus;
    private String deleteStatus;
    private UserV1 userV1;

}
