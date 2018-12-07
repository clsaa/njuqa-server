package com.clsaa.wechat.njuqa.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author joyren
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class NjuqaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NjuqaServerApplication.class, args);
    }
}

