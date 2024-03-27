package online.gladikov.laboratory.kafka_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "laboratory", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}
