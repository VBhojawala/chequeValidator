package com.validator.chequeValidator.service;

import com.validator.model.Cheque;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ChequeProducerService {

    @Autowired
    private KafkaTemplate<String, Cheque> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public void sendMessage(@Valid Cheque cheque) {
        log.info("Sending cheque to Kafka ....");

        Message<Cheque> message = MessageBuilder.withPayload(cheque).setHeader(KafkaHeaders.TOPIC, topicName).build();
        kafkaTemplate.send(message);
        log.info("Cheque sent !!");
    }
}
