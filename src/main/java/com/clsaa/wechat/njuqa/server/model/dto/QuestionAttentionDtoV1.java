package com.clsaa.wechat.njuqa.server.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class QuestionAttentionDtoV1 {
    private String userId;
    private String questionId;

}
