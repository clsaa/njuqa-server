package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.rest.result.bizassert.BizAssert;
import com.clsaa.rest.result.bizassert.BizCode;
import com.clsaa.wechat.njuqa.server.config.BizCodes;
import com.clsaa.wechat.njuqa.server.dao.AnswerDao;
import com.clsaa.wechat.njuqa.server.model.po.Answer;
import com.clsaa.wechat.njuqa.server.model.vo.AnswerV1;
import com.clsaa.wechat.njuqa.server.util.BeanUtils;
import com.clsaa.wechat.njuqa.server.util.TimestampUtil;
import com.clsaa.wechat.njuqa.server.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 答案相关业务逻辑
 *
 * @author joyren
 */
@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private UserService userService;

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public AnswerV1 addAnswer(String userId, String questionId, String content, String type) {
        Answer existAnswer = this.answerDao.findAnswerByUserIdAndQuestionId(userId, questionId);
        BizAssert.allowed(existAnswer == null, BizCodes.REPEATED_ANSWER);
        Answer answer = new Answer();
        answer.setId(UUIDUtil.getUUID());
        answer.setUserId(userId);
        answer.setQuestionId(questionId);
        answer.setContent(content);
        answer.setCtime(TimestampUtil.now());
        answer.setMtime(TimestampUtil.now());
        BizAssert.allowed(type.equals(Answer.TYPE_ANONYMOUS) ||
                        type.equals(Answer.TYPE_SHOW),
                new BizCode(BizCodes.INVALID_PARAM.getCode(),
                        "type 字段必须为 ： " + Answer.TYPE_ANONYMOUS + "或" + Answer.TYPE_SHOW));
        answer.setType(type);
        return BeanUtils.convertType(this.answerDao.saveAndFlush(answer), AnswerV1.class);
    }

    public boolean deleteAnswerById(String questionId, String answerId) {
        Answer existAnswer = this.answerDao.findAnswerById(answerId);
        BizAssert.allowed(questionId.equals(existAnswer.getQuestionId()),
                new BizCode(BizCodes.INVALID_PARAM.getCode(), "传入的问题id与查询问题不匹配"));
        BizAssert.found(existAnswer == null, BizCodes.NOT_FOUND);
        this.answerDao.delete(existAnswer);
        return true;
    }

    public AnswerV1 updateAnswerById(String id, String userId, String questionId, String content, String type) {
        Answer existAnswer = this.answerDao.findAnswerById(id);
        BizAssert.found(existAnswer == null, BizCodes.NOT_FOUND);
        BizAssert.allowed(questionId.equals(existAnswer.getUserId()), BizCodes.CANNOT_UPDATE_ANSWER);
        BizAssert.allowed(userId.equals(existAnswer.getUserId()), BizCodes.CANNOT_UPDATE_ANSWER);
        BizAssert.allowed(questionId.equals(existAnswer.getQuestionId()),
                new BizCode(BizCodes.CANNOT_UPDATE_ANSWER.getCode(), "问题id不可被修改"));
        BizAssert.allowed(type.equals(Answer.TYPE_ANONYMOUS) ||
                        type.equals(Answer.TYPE_SHOW),
                new BizCode(BizCodes.INVALID_PARAM.getCode(),
                        "type 字段必须为 ： " + Answer.TYPE_ANONYMOUS + "或" + Answer.TYPE_SHOW));
        existAnswer.setMtime(TimestampUtil.now());
        existAnswer.setContent(content);
        existAnswer.setType(type);
        return BeanUtils.convertType(existAnswer, AnswerV1.class);
    }

    public List<AnswerV1> findAnswersV1ByQuestionId(String questionId) {
        return this.answerDao.findAllByQuestionId(questionId).stream().map(s -> {
            AnswerV1 answerV1 = BeanUtils.convertType(s, AnswerV1.class);
            answerV1.setUserV1(this.userService.findUserV1ById(s.getUserId()));
            return answerV1;
        }).collect(Collectors.toList());
    }
}
