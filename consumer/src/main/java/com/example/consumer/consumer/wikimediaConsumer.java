package com.example.consumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@Slf4j
public class wikimediaConsumer {
    @KafkaListener(topics = "wikimedia_stream",groupId = "myGroup")
    public void consumeMsg(String msg){
        log.info(String.format("message consumed from wikimedia stream are %s",msg));
    }
}
