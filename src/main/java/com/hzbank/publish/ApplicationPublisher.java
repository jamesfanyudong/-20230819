package com.hzbank.publish;

import com.hzbank.event.BaseEventDto;
import com.hzbank.event.DemoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/2/1 09:10
 * @Description: TestApplicationContext
 * @Version 1.0.0
 */
@Component
@Slf4j
public class ApplicationPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(ApplicationEvent event){
        BaseEventDto source = (BaseEventDto) event.getSource();
        if (source.getDuplicate() == null || !source.getDuplicate()){
            applicationContext.publishEvent(new DemoEvent(source,null));
        }else {
            log.info("事件重复~");
        }
    }
}
