package com.ust.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(groupId = "group1",topics = "topic1")
    public void messageConsumer1(String message){
        System.out.println("Consumer 1 , Message Received :"+message);
    }

    @KafkaListener(groupId = "group2",topics = {"topic1","topic2"})
    public void messageConsumer2(String message){
        System.out.println("Consumer 2 ,Message Received :"+message);
    }
}
