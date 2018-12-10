package com.clsaa.wechat.njuqa.server.controller;

import com.clsaa.rest.result.bizassert.BizAssert;
import com.clsaa.rest.result.bizassert.BizCode;
import com.clsaa.wechat.njuqa.server.config.BizCodes;
import com.clsaa.wechat.njuqa.server.model.dto.AnswerDtoV1;
import com.clsaa.wechat.njuqa.server.model.vo.AnswerV1;
import com.clsaa.wechat.njuqa.server.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 答案相关接口
 *
 * @author joyren
 */
@RestController
@CrossOrigin
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    /**
     * <p>
     * 添加一个回答
     * </p>
     *
     * @param answerDtoV1 {@link AnswerDtoV1}
     * @return {@link AnswerV1}
     * @summary 添加回答
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-10
     */
    @PostMapping("/v1/question/answer")
    public AnswerV1 addAnswerV1(@RequestBody AnswerDtoV1 answerDtoV1) {
        return this.answerService.addAnswer(answerDtoV1.getUserId(),
                answerDtoV1.getQuestionId(),
                answerDtoV1.getContent(),
                answerDtoV1.getType());
    }


    /**
     * <p>
     * 根据id删除回答
     * </p>
     *
     * @param answerId 回答id
     * @return {@link boolean}
     * @summary 根据id删除回答
     * @author 任贵杰 812022339@qq.com
     * @since 2018-12-10
     */
    @DeleteMapping("/v1/question/{questionId}/answer/{answerId}")
    public boolean deleteAnswerByIdV1(@PathVariable("questionId") String questionId,
                                      @PathVariable("answerId") String answerId) {
        return this.answerService.deleteAnswerById(questionId, answerId);
    }

    @PutMapping("/v1/question/{questionId}/answer/{answerId}")
    public AnswerV1 updateAnswerByIdV1(@PathVariable("questionId") String questionId,
                                       @PathVariable("answerId") String answerId,
                                       @RequestBody AnswerDtoV1 answerDtoV1) {
        BizAssert.validParam(questionId.equals(answerDtoV1.getQuestionId()),
                new BizCode(BizCodes.INVALID_PARAM.getCode(), "路径questionId与传入参数questionId不符"));
        return this.answerService.updateAnswerById(answerId,
                answerDtoV1.getUserId(),
                answerDtoV1.getQuestionId(),
                answerDtoV1.getContent(),
                answerDtoV1.getType());
    }

    @GetMapping("/v1/question/{questionId}/answer/all/")
    public List<AnswerV1> findAnswersByQuestionIdV1(@PathVariable("questionId") String questionId) {
        return this.answerService.findAnswersV1ByQuestionId(questionId);
    }

}
