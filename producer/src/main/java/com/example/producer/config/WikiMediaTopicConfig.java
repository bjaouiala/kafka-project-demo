package com.example.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikiMediaTopicConfig {
    @Bean
    NewTopic wikiMediaTopic(){
        return TopicBuilder.name("wikimedia_stream").build();
    }
}
