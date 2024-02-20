package com.hzbank.listener;

import com.hzbank.event.DemoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/2/1 11:08
 * @Description: DemoEventListener
 * @Version 1.0.0
 */
@Component
@Slf4j
public class DemoEventListener implements ApplicationListener<DemoEvent> {
    @Override
    @Async
    public void onApplicationEvent(DemoEvent event) {
        log.info("监听器监听到事件~");
        log.info("事件是{}",event.getSource());
    }
}
