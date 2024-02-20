package com;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/1/25 13:07
 * @Description: Application
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableAsync
@EnableRabbit
public class Application {
    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(Application.class);
    }
}
