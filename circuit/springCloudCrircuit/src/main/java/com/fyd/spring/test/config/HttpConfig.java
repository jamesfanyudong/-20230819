package com.fyd.spring.test.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/4/21 19:46
 * @Description: HttpConfig
 * @Version 1.0.0
 */
@Configuration
public class HttpConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        builder.setConnectTimeout(Duration.ofSeconds(15L))
                .setReadTimeout(Duration.ofMinutes(300L));
        return builder.build();
    }

}
