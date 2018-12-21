package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.wechat.njuqa.server.dao.CommentDao;
import com.clsaa.wechat.njuqa.server.dao.UserDao;
import com.clsaa.wechat.njuqa.server.model.dto.CommentDtoV1;
import com.clsaa.wechat.njuqa.server.model.dto.UserDtoV1;
import com.clsaa.wechat.njuqa.server.model.po.Comment;
import com.clsaa.wechat.njuqa.server.model.po.User;
import com.clsaa.wechat.njuqa.server.util.TimestampUtil;
import com.clsaa.wechat.njuqa.server.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;

    public List<Comment> getCommentsByUserId(String userId){
        return commentDao.getCommentsByUserIdOrderByCtimeDesc(userId);
    }

    /*public List<Comment> getCommentsByAnswerId(String answerId){
        return commentDao.getCommentsByAnswerIdOrderByCtimeDesc(answerId);
    }*/

    public List<CommentDtoV1> getCommentsByAnswerId(String answerId){
        List<CommentDtoV1> result=new ArrayList<>();
        List<Comment> comments=commentDao.getCommentsByAnswerIdOrderByCtimeDesc(answerId);
        for (Comment comment:comments){
            String userId=comment.getUserId();
            User user=userDao.findUsersById(userId);
            CommentDtoV1 commentDtoV1=new CommentDtoV1();
            commentDtoV1.setComment(comment);
            commentDtoV1.setUser(user);
            result.add(commentDtoV1);

        }
        return result;
    }

    public Comment addComment(String userId,String answerId,String content){
        Comment comment=new Comment();
        comment.setUserId(userId);
        comment.setAnswerId(answerId);
        comment.setContent(content);
        comment.setCtime(TimestampUtil.now());
        comment.setMtime(TimestampUtil.now());
        comment.setId(UUIDUtil.getUUID());
        return commentDao.save(comment);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public void deleteComment(String userId,String answerId){
        commentDao.deleteCommentByAnswerIdAndUserId(userId,answerId);
    }
}