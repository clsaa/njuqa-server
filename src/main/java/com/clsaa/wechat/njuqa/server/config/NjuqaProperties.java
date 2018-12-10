package com.clsaa.wechat.njuqa.server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 配置属性类
 *
 * @author joyren
 */
@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "njuqa")
public class NjuqaProperties {


    @Valid
    @NotNull
    private Wechat wechat;

    /**
     * 微信小程序相关的配置
     */
    @Getter
    @Setter
    public static class Wechat {
        private String appid;
        private String secret;
    }
}
