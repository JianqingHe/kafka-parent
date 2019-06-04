package kafka.demo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author hejq
 * @date 2019/6/4 17:37
 */
@SpringBootApplication
public class KafkaCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaCustomerApplication.class, args);
    }

}
