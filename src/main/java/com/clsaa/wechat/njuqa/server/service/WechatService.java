package com.clsaa.wechat.njuqa.server.service;

import com.clsaa.wechat.njuqa.server.model.dto.WechatLoginUserDtoV1;
import feign.Param;
import feign.RequestLine;

/**
 * 对微信官方平台API请求
 *
 * @author joyren
 */
public interface WechatService {

    /**
     * 根据微信小程序客户端用户code获取用户唯一标志
     *
     * GET https://api.weixin.qq.com/sns/jscode2session?appid=wx3a389d4403d72f0f&secret=275c59ebcee8d44884457b16b9650436&js_code=071klLIJ0mPp2820fFJJ0A1EIJ0klLIO&grant_type=authorization_code
     * @return {@link WechatLoginUserDtoV1}
     */
    @RequestLine("GET /sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}")
    WechatLoginUserDtoV1 getUserInfoByCode(@Param("appid") String appid,
                                           @Param("secret") String secret,
                                           @Param("js_code") String js_code,
                                           @Param("grant_type") String grant_type);
}
