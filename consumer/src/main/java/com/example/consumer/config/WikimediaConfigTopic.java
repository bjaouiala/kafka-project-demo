package com.example.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikimediaConfigTopic {
    @Bean
    public NewTopic kafkaTopic(){
        return TopicBuilder.name("wikimedia_stream").build();
    }
}
