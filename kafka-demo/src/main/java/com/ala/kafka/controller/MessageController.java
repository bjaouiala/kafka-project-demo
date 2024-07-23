package com.ala.kafka.controller;

import com.ala.kafka.paylod.Student;
import com.ala.kafka.producer.KafkaJsonConsumer;
import com.ala.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonConsumer kafkaJsonConsumer;
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent succefully");
    }
    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(@RequestBody Student message){
        kafkaJsonConsumer.sendMessage(message);
        return ResponseEntity.ok("json message sent succefully");
    }
}
