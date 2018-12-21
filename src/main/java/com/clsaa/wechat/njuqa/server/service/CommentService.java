package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.wechat.njuqa.server.dao.CommentDao;
import com.clsaa.wechat.njuqa.server.model.po.Comment;
import com.clsaa.wechat.njuqa.server.model.vo.CommentV1;
import com.clsaa.wechat.njuqa.server.util.BeanUtils;
import com.clsaa.wechat.njuqa.server.util.TimestampUtil;
import com.clsaa.wechat.njuqa.server.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserService userService;

    public List<Comment> getCommentsByUserId(String userId) {
        return commentDao.getCommentsByUserIdOrderByCtimeDesc(userId);
    }

    public List<CommentV1> getCommentsByAnswerId(String answerId) {
        return commentDao.getCommentsByAnswerIdOrderByCtimeDesc(answerId)
                .stream().map(c -> {
                    CommentV1 commentV1 = BeanUtils.convertType(c, CommentV1.class);
                    commentV1.setUserV1((this.userService.findUserV1ById(commentV1.getUserId())));
                    return commentV1;
                }).collect(Collectors.toList());
    }

    public Comment addComment(String userId, String answerId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setAnswerId(answerId);
        comment.setContent(content);
        comment.setCtime(TimestampUtil.now());
        comment.setMtime(TimestampUtil.now());
        comment.setId(UUIDUtil.getUUID());
        return commentDao.save(comment);
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public void deleteComment(String userId, String answerId) {
        commentDao.deleteCommentByAnswerIdAndUserId(userId, answerId);
    }
}