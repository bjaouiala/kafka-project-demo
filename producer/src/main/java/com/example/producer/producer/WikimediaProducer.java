package com.example.producer.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WikimediaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void senMessage(String msg){
        // log.info(String.format("the message sent to the topic succefully :: %s",msg));
        kafkaTemplate.send("wikimedia_stream",msg);
    }
}
