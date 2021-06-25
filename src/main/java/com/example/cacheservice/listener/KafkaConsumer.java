package com.example.cacheservice.listener;

import com.example.cacheservice.model.Posting;
import com.example.cacheservice.repo.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private PostingRepository postingRepository;

    @KafkaListener(topics = "Kafka_String_Topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "Kafka_Posting_Topic", groupId = "group_json",
            containerFactory = "postingKafkaListenerFactory")
    public void consumeJson(Posting posting) {
        postingRepository.save(posting);
        System.out.println("Consumed JSON Message: " + posting.getContent());
    }
}
