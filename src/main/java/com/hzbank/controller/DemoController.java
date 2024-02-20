package com.hzbank.controller;

import com.hzbank.event.BaseEventDto;
import com.hzbank.event.DemoEvent;
import com.hzbank.publish.ApplicationPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/2/1 11:13
 * @Description: DemoController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/fyd")
public class DemoController {

    @Autowired
    ApplicationPublisher applicationPublisher;
    @GetMapping("/demoEven")
    public String demoEvenPublish(){
        DemoEvent event = new DemoEvent(new BaseEventDto(), "demo事件");
        applicationPublisher.publishEvent(event);
        return "事件发布成功";
    }
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 发布一个事件
     * @param params
     * @return
     */
    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody Map params) {
        String id = UUID.randomUUID().toString();
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        params.put("messageId",id);
        params.put("createTime",createTime);
        /**
         * 发给交换机，在发给路由绑定的队列
         */
        rabbitTemplate.convertAndSend("direct.test1","testRoute",params);
        return "成功";
    }

//    @GetMapping("/consume")
//    public String sendMessage(){
//        Object me = rabbitTemplate.receiveAndConvert("queue.test1");
//    }

}
