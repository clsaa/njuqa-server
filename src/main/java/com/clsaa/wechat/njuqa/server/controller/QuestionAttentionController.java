package com.clsaa.wechat.njuqa.server.controller;

import com.clsaa.wechat.njuqa.server.model.dto.AnswerDtoV1;
import com.clsaa.wechat.njuqa.server.model.dto.QuestionAttentionDtoV1;
import com.clsaa.wechat.njuqa.server.model.po.QuestionAttention;
import com.clsaa.wechat.njuqa.server.model.vo.AnswerV1;
import com.clsaa.wechat.njuqa.server.model.vo.QuestionAttentionV1;
import com.clsaa.wechat.njuqa.server.model.vo.QuestionV1;
import com.clsaa.wechat.njuqa.server.service.AnswerService;
import com.clsaa.wechat.njuqa.server.service.QuestionAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class QuestionAttentionController {
    @Autowired
    private QuestionAttentionService questionAttentionService;

    /**
     * 添加一个问题关注
     * @param questionAttentionDtoV1
     * @return
     */
    @PostMapping("/v1/question/attention")
    public QuestionAttentionV1 addQuestionAttentionV1(@RequestBody QuestionAttentionDtoV1 questionAttentionDtoV1) {
        return this.questionAttentionService.addQuestionAttention(questionAttentionDtoV1.getUserId(),
                questionAttentionDtoV1.getQuestionId());
    }

    /**
     * 删除一个问题关注
     * @param questionId
     * @param userId
     * @return
     */
    @DeleteMapping("/v1/question/{questionId}/user/{userId}")
    public boolean deleteQuestionAttentionById(@PathVariable("questionId") String questionId,
                                      @PathVariable("userId") String userId) {
        return this.questionAttentionService.deleteQuestionAttentionById(questionId, userId);
    }

    /**
     * 用户关注了那些问题
     * @param userId
     * @return
     */
    @GetMapping("/v1/user/{userId}/question/all/")
    public List<QuestionV1> findQuestionsByUserId(@PathVariable("userId") String userId) {
        return this.questionAttentionService.findQuestionsByUserId(userId);
    }
}
