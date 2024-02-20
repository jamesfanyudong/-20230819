package com.hzbank.event;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/2/1 09:16
 * @Description: DemoEvent
 * @Version 1.0.0
 */
@Slf4j
public  class DemoEvent extends ApplicationEvent {


    public DemoEvent(BaseEventDto source, String desp) {
        super(source);
        this.source = source;
        log.info("事件DemoEvent  === {}",desp);

    }
}
