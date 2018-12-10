package com.clsaa.wechat.njuqa.server.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author joyren
 */
@Getter
@Setter
public class AnswerDtoV1 {
    private String id;
    private String userId;
    private String questionId;
    private String content;
    private String type;
}
