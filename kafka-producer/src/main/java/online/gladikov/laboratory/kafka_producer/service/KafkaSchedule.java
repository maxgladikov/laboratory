package online.gladikov.laboratory.kafka_producer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@EnableAsync
@Component
public class KafkaSchedule {

    @Value(value = "${spring.kafka.topic}")
    private String topic;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final AtomicInteger counter = new AtomicInteger (0);

    public void sendMessage(String msg) {
        kafkaTemplate.send(topic, msg);
    }

//    @Async
    @Scheduled(fixedRate = 5000)
    public void produce(){
        sendMessage("hello #"+counter.getAndIncrement ());
        ProducerRecord<String, String> record =
            new ProducerRecord<>("CustomerCountry", "Precision Products",
                "France");
    }

}
