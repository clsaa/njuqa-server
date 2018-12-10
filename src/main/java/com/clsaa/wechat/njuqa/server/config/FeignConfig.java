package com.clsaa.wechat.njuqa.server.config;

import com.clsaa.wechat.njuqa.server.service.WechatService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author joyren
 */
@SpringBootConfiguration
public class FeignConfig {
    @Autowired
    private NjuqaProperties njuqaProperties;

    @Bean("WechatService")
    public WechatService buildWechatService() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(5000, 7500))
                .retryer(new Retryer.Default(5000, 5000, 1))
                .target(WechatService.class, "https://api.weixin.qq.com");
    }
}
