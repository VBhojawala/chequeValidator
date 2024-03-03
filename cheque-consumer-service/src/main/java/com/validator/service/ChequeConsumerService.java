package com.validator.service;

import com.validator.entity.EncashedCheque;
import com.validator.mapper.ChequeMapper;
import com.validator.model.Cheque;
import com.validator.model.EnCashedCheques;
import com.validator.repository.EncashedChequeRespoitory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class ChequeConsumerService {
    @Autowired
    private ChequeMapper chequeMapper;

    @Autowired
    private EncashedChequeRespoitory encashedChequeRespoitory;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload Cheque cheque, @Headers MessageHeaders headers) {
        log.info("Message received" + cheque.toString());

        log.info("Mapping cheque to entity");
        EncashedCheque encashedCheque = chequeMapper.modelToEntity(cheque);

        log.info("saving enCashed cheque to database");
        encashedChequeRespoitory.save(encashedCheque);
        log.info("cheque saved into database");

    }

    public EnCashedCheques findEnCashedChequeByDate(LocalDate date) {
        log.info("Finding all enCashed cheque by date : " + date);

        List<EncashedCheque> enCashedCheques = encashedChequeRespoitory.findByEnCashedDate(date);

        if (enCashedCheques == null)
            return null;

        List<Cheque> cheques = new ArrayList<>();
        log.info("Mapping Entity to model for each enCashedCheque : ");

        for (EncashedCheque encashedCheque : enCashedCheques) {
            cheques.add(chequeMapper.entityToModel(encashedCheque));
        }

        EnCashedCheques enCashedChequesModel = new EnCashedCheques();
        enCashedChequesModel.setEnCashedCheques(cheques);
        return enCashedChequesModel;
    }
}
