package com.clsaa.wechat.njuqa.server.dao;

import com.clsaa.wechat.njuqa.server.model.po.Question;
import com.clsaa.wechat.njuqa.server.model.vo.QuestionV1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.BitSet;
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
}
