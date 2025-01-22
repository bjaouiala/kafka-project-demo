package com.ala.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ScheduledFuture;

@Service
@Slf4j

public class KafkaProducer {
    private static final String FILE_PATH = "D:\\file.txt";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private BufferedReader reader;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        try {
            this.reader = Files.newBufferedReader(Paths.get(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 2000)
    public void sendMessage() {
        try {
            if (reader == null) {
                reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            }

            String line = reader.readLine();
            if (line != null) {
                kafkaTemplate.send("first", line);
                log.info("Sending message from 'first' topic: {}", line);
            } else {
                reader.close();
                reader = null;
                log.info("Reached end of file. Restarting from beginning.");
            }
        } catch (IOException e) {
            log.error("Error reading file or sending message to Kafka", e);
        }
    }
}
