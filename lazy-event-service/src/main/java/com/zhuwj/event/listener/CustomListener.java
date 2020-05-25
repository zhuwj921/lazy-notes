package com.zhuwj.event.listener;

import com.zhuwj.event.events.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Description: 自定义事件监听器
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-25
 */

@Slf4j
@Component
public class CustomListener {

    /**
     * AFTER_COMMIT （默认），事务提交后
     * AFTER_ROLLBACK ，事务回滚后
     * AFTER_COMPLETION ，事务完成，包括提交后和回滚后
     * BEFORE_COMMIT ，事务提交前
     * @param customEvent
     */
    @Order(1)
    @Async
    @EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleCustomEvent(CustomEvent customEvent){
        log.info("custom event source {} message {}",customEvent.getSource(),customEvent.getMessage());
    }

}
