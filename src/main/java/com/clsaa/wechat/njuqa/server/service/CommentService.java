package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.wechat.njuqa.server.dao.CommentDao;
import com.clsaa.wechat.njuqa.server.model.po.Comment;
import com.clsaa.wechat.njuqa.server.util.TimestampUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    public List<Comment> getCommentsByUserId(String userId){
        return commentDao.getCommentsByUserIdOrderByCtimeDesc(userId);
    }

    public Comment addComment(String userId,String answerId,String content){
        Comment comment=new Comment();
        comment.setUserId(userId);
        comment.setAnswerId(answerId);
        comment.setContent(content);
        comment.setCtime(TimestampUtil.now());
        comment.setMtime(TimestampUtil.now());
        return commentDao.save(comment);
    }

    public void deleteComment(String userId,String answerId){
        commentDao.deleteCommentByAnswerIdAndUserId(userId,answerId);
    }
}