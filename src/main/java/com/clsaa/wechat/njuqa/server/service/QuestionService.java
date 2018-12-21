package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.wechat.njuqa.server.dao.AnswerDao;
import com.clsaa.wechat.njuqa.server.dao.QuestionDao;
import com.clsaa.wechat.njuqa.server.model.po.Question;
import com.clsaa.wechat.njuqa.server.model.vo.AnswerV1;
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
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private UserService userService;


    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public QuestionV1 addQuestion(String userId, String content) {

        Question question = new Question();
        question.setId(UUIDUtil.getUUID());
        question.setUserId(userId);
        question.setContent(content);
        question.setCloseStatus("0");
        question.setDeleteStatus("0");

        question.setCtime(TimestampUtil.now());
        question.setMtime(TimestampUtil.now());

        return BeanUtils.convertType(this.questionDao.saveAndFlush(question), QuestionV1.class);
    }

    public QuestionV1 updateQuestionCloseStatueById(String questionId, String closeStatus) {
        Question existQuestion = this.questionDao.findQuestionById(questionId);
        if (existQuestion != null) {
            existQuestion.setCloseStatus(closeStatus);
            this.questionDao.saveAndFlush(existQuestion);
            return BeanUtils.convertType(existQuestion, QuestionV1.class);
        } else {
            return null;
        }

    }

    public QuestionV1 updateQuestionDeleteStatueById(String questionId, String deleteStatus) {
        Question existQuestion = this.questionDao.findQuestionById(questionId);
        if (existQuestion != null) {
            existQuestion.setDeleteStatus(deleteStatus);
            this.questionDao.saveAndFlush(existQuestion);
            return BeanUtils.convertType(existQuestion, QuestionV1.class);
        } else {
            return null;
        }

    }


    public List<QuestionV1> findQuestionsByUserIdWithAnswer(String userId) {
        return this.answerDao.findAllByUserIdOrderByMtimeDesc(userId).stream().map(a -> {

            AnswerV1 answerV1 = BeanUtils.convertType(a, AnswerV1.class);
            Question question = questionDao.findQuestionById(answerV1.getQuestionId());
            QuestionV1 questionV1 = BeanUtils.convertType(question, QuestionV1.class);

            return questionV1;
        }).collect(Collectors.toList());
    }


    public List<QuestionV1> findQuestionsByUserId(String userId) {
        return this.questionDao.findAllQuestionsByUserIdOrderByMtimeDesc(userId).stream().map(a -> {


            QuestionV1 questionV1 = BeanUtils.convertType(a, QuestionV1.class);

            return questionV1;
        }).collect(Collectors.toList());
    }


    public List<QuestionV1> findAllQuestions() {
        return this.questionDao.findAll().stream().map(a -> {
            QuestionV1 questionV1 = BeanUtils.convertType(a, QuestionV1.class);
            questionV1.setUserV1(this.userService.findUserV1ById(questionV1.getUserId()));
            return questionV1;
        }).collect(Collectors.toList());
    }
}
