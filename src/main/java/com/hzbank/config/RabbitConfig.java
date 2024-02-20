package com.hzbank.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    /**
     * 队列
     */
    @Bean
    Queue createDirectQueue(){
        /**
         * durable:是否持久化,默认是false。true为持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在；false为暂存队列：当前连接有效。
         * exclusive:默认也是false。true是只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable。
         * autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
         * 一般设置一下队列的持久化就好,其余两个就是默认false
         */
        //两种创建方式
        //QueueBuilder.durable("queue.test1").build();
        return new Queue("queue.test1",true,false,false);
    }

    /**
     *  交换机
     */
    @Bean
    DirectExchange createDirectExchange(){
        /**
         * durable、autoDelete参数性质和上面队列的一致
         */
        return new DirectExchange("direct.test1",true,false);
    }

    /**
     * 将队列和交换机绑定, 并设置用于匹配键
     */
    @Bean
    Binding binding(){
        return BindingBuilder.bind(createDirectQueue()).to(createDirectExchange()).with("testRoute");
    }

}
