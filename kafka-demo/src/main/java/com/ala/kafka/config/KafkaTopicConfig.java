package com.ala.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.concurrent.ScheduledFuture;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic FirstTopic(){
        return TopicBuilder.name("first").build();
    }

}
