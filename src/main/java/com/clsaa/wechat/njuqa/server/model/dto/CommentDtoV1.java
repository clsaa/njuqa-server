package com.clsaa.wechat.njuqa.server.model.dto;

import com.clsaa.wechat.njuqa.server.model.po.Comment;
import com.clsaa.wechat.njuqa.server.model.po.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class CommentDtoV1 {
    private Comment comment;
    private User user;
}
