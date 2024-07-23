package com.ala.kafka.consumer;

import com.ala.kafka.paylod.Student;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.*;

@Service
@Slf4j
public class KafkaConsumer {
//    //@KafkaListener(topics = "first",groupId = "myGroup")
//    public void consumeMessage(String message){
//        log.info(format("consuming message from first topic :: %s",message));
//    }
    @KafkaListener(topics = "first",groupId = "myGroup")
    public void consumeJsonMessage(Student message){
        log.info(format("consuming message from first topic :: %s",message));
    }
}
