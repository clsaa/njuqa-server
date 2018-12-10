package com.clsaa.wechat.njuqa.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author joyren
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@ComponentScan("com.clsaa")
public class NjuqaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NjuqaServerApplication.class, args);
    }
}

