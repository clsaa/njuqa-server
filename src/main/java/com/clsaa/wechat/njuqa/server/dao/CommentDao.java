package com.clsaa.wechat.njuqa.server.dao;

import com.clsaa.wechat.njuqa.server.model.po.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,String> {

    List<Comment> getCommentsByUserIdOrderByCtimeDesc(String userId);

    List<Comment> getCommentsByAnswerIdOrderByCtimeDesc(String answerId);

    void deleteCommentByAnswerIdAndUserId(String answerId,String userId);



}
