package com.clsaa.wechat.njuqa.server.controller;

import com.clsaa.rest.result.bizassert.BizAssert;
import com.clsaa.rest.result.bizassert.BizCode;
import com.clsaa.wechat.njuqa.server.config.BizCodes;
import com.clsaa.wechat.njuqa.server.model.dto.AnswerDtoV1;
import com.clsaa.wechat.njuqa.server.model.dto.QuestionDtoV1;
import com.clsaa.wechat.njuqa.server.model.po.Question;
import com.clsaa.wechat.njuqa.server.model.vo.AnswerV1;
import com.clsaa.wechat.njuqa.server.model.vo.QuestionV1;
import com.clsaa.wechat.njuqa.server.service.AnswerService;
import com.clsaa.wechat.njuqa.server.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 添加问题
     * @param questionDtoV1
     * @return
     */
    @PostMapping("/v1/question")
    public QuestionV1 addQuestionV1(@RequestBody QuestionDtoV1 questionDtoV1) {
        return this.questionService.addQuestion(questionDtoV1.getUserId(),
                questionDtoV1.getContent()
                );
    }

    /**
     * 将问题状态修改成关闭
     * @param questionId
     * @param closeStatus
     * @return
     */
    @PutMapping("/v1/question/{questionId}/close/statue/{closeStatus}")
    public QuestionV1 updateQuestionCloseStatueById(@PathVariable("questionId") String questionId,
                                       @PathVariable("closeStatus") String closeStatus) {

        return this.questionService.updateQuestionCloseStatueById(questionId,closeStatus);
    }

    /**
     * 将问题状态修改成删除
     * @param questionId
     * @param deleteStatues
     * @return
     */
    @PutMapping("/v1/question/{questionId}/delete/statue/{deleteStatus}")
    public QuestionV1 updateQuestionDeleteStatueById(@PathVariable("questionId") String questionId,
                                         @PathVariable("deleteStatus") String deleteStatues) {

        return this.questionService.updateQuestionDeleteStatueById(questionId,deleteStatues);
    }



    /**
     * 用户回答了的那些问题
     * @param userId
     * @return
     */
    @GetMapping("/v1/user/{userId}/answer/question/all/")
    public List<QuestionV1> findQuestionsByUserIdWithAnswer(@PathVariable("userId") String userId) {
        return this.questionService.findQuestionsByUserIdWithAnswer(userId);
    }

}
