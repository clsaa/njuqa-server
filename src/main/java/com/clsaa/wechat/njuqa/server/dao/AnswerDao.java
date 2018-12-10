package com.clsaa.wechat.njuqa.server.dao;

import com.clsaa.wechat.njuqa.server.model.po.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Answer数据访问层
 *
 * @author joyren
 */
public interface AnswerDao extends JpaRepository<Answer, String> {

    /**
     * 根据id查询回答
     *
     * @param id 回答id
     * @return {@link Answer}
     */
    Answer findAnswerById(String id);

    /**
     * 根据用户id和问题id查询答案
     *
     * @param userId     用户id
     * @param questionId 问题id
     * @return {@link Answer}
     */
    Answer findAnswerByUserIdAndQuestionId(String userId, String questionId);

    /**
     * 根据问题id查询全部回答
     *
     * @param questionId 问题id
     * @return {@link List<Answer>}
     */
    List<Answer> findAllByQuestionIdOrderByMtimeDesc(String questionId);

    /**
     * 查询关注用户的最新答案
     *
     * @param userId 用户id
     * @return {@link List<Answer>}
     */
    @Query(value = "select a.* " +
            " from t_answer a inner join t_user_attention ua on a.user_id = ua.target_user " +
            " where ua.source_user = :user_id " +
            " and a.type = 'SHOW'" +
            " order by a.ctime desc " +
            " limit 20", nativeQuery = true)
    List<Answer> findAnswersByUserAttention(@Param("user_id") String userId);
}
