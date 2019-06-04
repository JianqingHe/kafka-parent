package kafka.demo.customer.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * 接收消息
 *
 * @author hejq
 * @date 2019/6/4 17:56
 */
@Component
public class ReceiveMessage {

    /**
     * 接收消息数据
     *
     * @param message 接收到的消息内容
     */
    @KafkaListener(topics = {"kafka-producer"})
    public void receive(String message){
        System.out.println("--消费消息, time: " + LocalTime.now() + " msg -> " + message);
    }
}
