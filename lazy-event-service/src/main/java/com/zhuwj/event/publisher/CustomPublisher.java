package com.zhuwj.event.publisher;

import com.zhuwj.event.events.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Description: TODO
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-25
 */

@Component
public class CustomPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void event(String message){
        applicationEventPublisher.publishEvent(new CustomEvent("spring-boot",message));
    }
}
