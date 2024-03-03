package com.validator.config;

import com.validator.model.Cheque;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChequeConsumerConfigTest {

    ChequeConsumerConfig chequeConsumerConfig = new ChequeConsumerConfig();

    @Test
    void testChequeConsumerFactory() {
        ConsumerFactory<String, Cheque> cf = chequeConsumerConfig.chequeConsumerFactory();
        assertNotNull(cf);
    }

    @Test
    void testKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Cheque> klcf = chequeConsumerConfig
                .kafkaListenerContainerFactory();
        assertNotNull(klcf);
    }

}