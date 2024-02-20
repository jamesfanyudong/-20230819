package com.hzbank.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/2/4 10:08
 * @Description: TestConsumer
 * @Version 1.0.0
 */
@Component
@RabbitListener(queues = "queue.test1")
public class TestConsumer {
    @RabbitHandler
    public void process(Map message){
        System.out.printf("消费者接收到消息：" + message.toString());
    }


}
