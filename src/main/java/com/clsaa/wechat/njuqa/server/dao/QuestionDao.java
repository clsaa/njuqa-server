package com.clsaa.wechat.njuqa.server.dao;

import com.clsaa.wechat.njuqa.server.model.po.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, String> {
    /**
     * 根据id找Question
     * @param id
     * @return
     */
    Question findQuestionById(String id);

    /**
     * 返回自己提出的问题
     * @param userId
     * @return
     */
    List<Question> findAllQuestionsByUserIdOrderByMtimeDesc(String userId);

    List<Question> findAll();
}
