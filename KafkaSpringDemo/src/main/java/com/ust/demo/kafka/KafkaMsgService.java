package com.ust.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMsgService {
    @Autowired
    KafkaTemplate kafkaTemplate;
    private static final String TOPIC ="topic1";

    public void publish(String message){
        kafkaTemplate.send(TOPIC,message);
    }
}
