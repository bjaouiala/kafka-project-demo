package com.ala.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message){
        log.info(String.format("sending message from first topic :: %s",message));
        kafkaTemplate.send("first",message);
    }
}
