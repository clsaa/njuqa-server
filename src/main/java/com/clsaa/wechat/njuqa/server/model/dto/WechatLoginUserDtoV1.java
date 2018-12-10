package com.clsaa.wechat.njuqa.server.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WechatLoginUserDtoV1 {
    private String openid;
    private String session_key;
    private String unionid;
    private Integer errcode;
    private String errmsg;
}
