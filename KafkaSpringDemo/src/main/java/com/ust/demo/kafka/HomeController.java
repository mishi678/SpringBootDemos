package com.ust.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    KafkaMsgService kafkaMsgService;
    @GetMapping("publish")
    public String publishMessage(@RequestParam("message") String message){
        System.out.println("Messge to publish "+message);
        kafkaMsgService.publish(message);
        return "Message Published : " +message;
    }
}
