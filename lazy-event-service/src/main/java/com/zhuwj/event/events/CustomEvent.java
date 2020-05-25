package com.zhuwj.event.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Description: 自定义事件
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-25
 */

public class CustomEvent extends ApplicationEvent {

    @Getter
    private String message;

    public CustomEvent(Object source,String message) {
        super(source);
        this.message = message;
    }
}
