package com.validator.config;

import com.validator.constants.KafkaConstants;
import com.validator.model.Cheque;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
class ChequeConsumerConfig {

    @Bean
    public ConsumerFactory<String, Cheque> chequeConsumerFactory() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.SERVER_CONFIG);
        map.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP);
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), new JsonDeserializer<>(Cheque.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Cheque> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Cheque> kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(chequeConsumerFactory());
        return kafkaListenerContainerFactory;
    }
}
