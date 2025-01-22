package com.example.producer.controller;

import com.example.producer.Stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wikimedia")
public class WikiMediaController {
    private final WikimediaStreamConsumer streamConsumer;
    @GetMapping
    public void startPublished(){
        streamConsumer.consumeStream();
    }
}
