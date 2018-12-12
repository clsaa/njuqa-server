package com.clsaa.wechat.njuqa.server.service;


import com.clsaa.rest.result.bizassert.BizAssert;
import com.clsaa.rest.result.bizassert.BizCode;
import com.clsaa.wechat.njuqa.server.config.BizCodes;
import com.clsaa.wechat.njuqa.server.dao.QuestionAttentionDao;
import com.clsaa.wechat.njuqa.server.dao.QuestionDao;
import com.clsaa.wechat.njuqa.server.model.po.Answer;
import com.clsaa.wechat.njuqa.server.model.po.Question;
import com.clsaa.wechat.njuqa.server.model.po.QuestionAttention;
import com.clsaa.wechat.njuqa.server.model.vo.QuestionAttentionV1;
import com.clsaa.wechat.njuqa.server.model.vo.QuestionV1;
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
public class QuestionAttentionService {
    @Autowired
    private QuestionAttentionDao questionAttentionDao;
    @Autowired
    private QuestionDao questionDao;

    /**
     * 添加用户关注问题
     * @param userId
     * @param questionId
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public QuestionAttentionV1 addQuestionAttention(String userId, String questionId) {
        QuestionAttention questionAttention=new QuestionAttention();
        questionAttention.setId(UUIDUtil.getUUID());
        questionAttention.setUserId(userId);
        questionAttention.setQuestionId(questionId);
        questionAttention.setMtime(TimestampUtil.now());
        questionAttention.setCtime(TimestampUtil.now());

        return BeanUtils.convertType(this.questionAttentionDao.saveAndFlush(questionAttention), QuestionAttentionV1.class);
    }

    /**
     * 删除用户关注问题
     * @param questionId
     * @param userId
     * @return
     */
    public boolean deleteQuestionAttentionById(String questionId, String userId) {
        QuestionAttention existQuestionAttention=this.questionAttentionDao.findQuestionAttentionByUserIdAndQuestionId(userId,questionId);
//        Answer existAnswer = this.answerDao.findAnswerById(answerId);
//        BizAssert.allowed(questionId.equals(existAnswer.getQuestionId()),
//                new BizCode(BizCodes.INVALID_PARAM.getCode(), "传入的问题id与查询问题不匹配"));
//        BizAssert.found(existAnswer != null, BizCodes.NOT_FOUND);
//        this.answerDao.delete(existAnswer);
        if(existQuestionAttention!=null){
            this.questionAttentionDao.delete(existQuestionAttention);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 返回用户全部关注的问题
     * @param userId
     * @return
     */
    public List<QuestionV1> findQuestionsByUserId(String userId) {

        return this.questionAttentionDao.findAllByUserIdOrderByMtimeDesc(userId).stream().map(a->{

            QuestionAttentionV1 questionAttentionV1=BeanUtils.convertType(a,QuestionAttentionV1.class);
            Question question=questionDao.findQuestionById(questionAttentionV1.getQuestionId());
            QuestionV1 questionV1=BeanUtils.convertType(question,QuestionV1.class);

            return questionV1;
        }).collect(Collectors.toList());
    }
}
