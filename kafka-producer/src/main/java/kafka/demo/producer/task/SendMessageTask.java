package kafka.demo.producer.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalTime;

/**
 * 发送消息任务
 *
 * @author hejq
 * @date 2019/6/4 17:39
 */
@Component
@EnableScheduling
public class SendMessageTask {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 定时发送消息
     */
    @Scheduled(cron = "0/5 * * * * ? ")
    public void sendMsg() {
        String message = "hello!! " + LocalTime.now();
        ListenableFuture future = kafkaTemplate.send("kafka-producer", message);
        future.addCallback(o ->
                System.out.println("send-消息发送成功：" + message),
                throwable -> System.out.println("消息发送失败：" + message));
    }
}
