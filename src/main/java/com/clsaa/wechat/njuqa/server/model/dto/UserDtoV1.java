package com.clsaa.wechat.njuqa.server.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author joyren
 */
@Getter
@Setter
public class UserDtoV1 {
    private String id;
    private String username;
    private String nickname;
    private String avatarUrl;
    private String type;
}
