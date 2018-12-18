package com.clsaa.wechat.njuqa.server.controller;

import com.clsaa.wechat.njuqa.server.model.po.Comment;
import com.clsaa.wechat.njuqa.server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value="/comment/getAllByUserId")
    public List<Comment> getCommentsByUserId(@RequestParam(value = "userId") String userId){
        return commentService.getCommentsByUserId(userId);
    }

    @PostMapping(value = "/comment/addComment")
    public Comment addComment(@RequestParam(value = "userId") String userId,@RequestParam(value = "answerId")String answerId,@RequestParam(value = "content")String content){
        return commentService.addComment(userId,answerId,content);
    }

    @DeleteMapping(value = "/comment/deleteComment")
    public void deleteComment(@RequestParam(value = "userId") String userId,@RequestParam(value = "answerId")String answerId){
        commentService.deleteComment(userId, answerId);
    }

}
