package com.clsaa.wechat.njuqa.server.config;

import com.clsaa.rest.result.bizassert.BizCode;

/**
 * @author 任贵杰
 */
public interface BizCodes {
    /**
     * 非法请求
     */
    BizCode INVALID_PARAM = new BizCode(1000, "请求参数非法");
    /**
     * 非法请求
     */
    BizCode NOT_FOUND = new BizCode(1001, "数据不存在");
    /**
     * 数据库插入失败
     */
    BizCode ERROR_INSERT = new BizCode(1010, "新增失败");
    /**
     * 数据库删除失败
     */
    BizCode ERROR_DELETE = new BizCode(1011, "删除失败");
    /**
     * 数据库更新失败
     */
    BizCode ERROR_UPDATE = new BizCode(1012, "更新失败");
    /**
     * 用户已回答过此问题
     */
    BizCode REPEATED_ANSWER = new BizCode(1050, "用户已回答过此问题,无法回答");
    /**
     * 用户只能修改自己的回答
     */
    BizCode CANNOT_UPDATE_ANSWER = new BizCode(1051, "用户只能修改自己的回答");
    /**
     * 重复的用户关注
     */
    BizCode REPEATED_USER_ATTENTION = new BizCode(1052, "已关注此用户");
}