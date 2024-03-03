package com.validator.chequeValidator.service;

import com.validator.chequeValidator.util.ChequeUtil;
import com.validator.model.Cheque;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;

@ExtendWith(MockitoExtension.class)
class ChequeProducerServiceTest {

    @Mock
    private KafkaTemplate<String, Cheque> kafkaTemplate;

    @InjectMocks
    private ChequeProducerService chequeProducerService;

    @Test
    void testSendMessage() {
        chequeProducerService.sendMessage(ChequeUtil.createCheque());
        Mockito.verify(kafkaTemplate, Mockito.times(1)).send(Mockito.any(Message.class));
    }

}