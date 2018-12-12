package com.clsaa.wechat.njuqa.server.dao;

import com.clsaa.wechat.njuqa.server.model.po.Question;
import com.clsaa.wechat.njuqa.server.model.po.QuestionAttention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionAttentionDao extends JpaRepository<QuestionAttention, String> {
    /**
     * 根据用户id和问题id查询问题关注
     *
     */
    QuestionAttention findQuestionAttentionByUserIdAndQuestionId(String userId, String questionId);

    /**
     * 根据用户id查询全部关注问题
     */
    List<QuestionAttention> findAllByUserIdOrderByMtimeDesc(String userId);
}
