package publisher;

import com.zhuwj.event.EventAppliaction;
import com.zhuwj.event.publisher.CustomPublisher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventAppliaction.class)
class CustomPublisherTest {

    @Autowired
    private CustomPublisher customPublisher;

    @Test
    void event() {
        customPublisher.event("自定义事件");
    }
}