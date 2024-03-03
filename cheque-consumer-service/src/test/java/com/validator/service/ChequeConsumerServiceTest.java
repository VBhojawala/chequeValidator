package com.validator.service;

import com.validator.mapper.ChequeMapper;
import com.validator.model.EnCashedCheques;
import com.validator.repository.EncashedChequeRespoitory;
import com.validator.util.EnCashedChequeUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.MessageHeaders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChequeConsumerServiceTest {

    @Mock
    private ChequeMapper chequeMapper;

    @Mock
    private EncashedChequeRespoitory encashedChequeRespoitory;

    @Mock
    MessageHeaders messageHeaders;

    @InjectMocks
    ChequeConsumerService chequeConsumerService;

    @Test
    void testConsume() {
        chequeConsumerService.consume(EnCashedChequeUtil.createCheque(), messageHeaders);
        verify(chequeMapper, times(1)).modelToEntity(any());
        verify(encashedChequeRespoitory, times(1)).save(any());
    }

    @Test
    void testFindEnCashedChequeByDate(){
        when(encashedChequeRespoitory.findByEnCashedDate(any())).thenReturn(EnCashedChequeUtil.createEnCashedChequesList());
        EnCashedCheques enCashedCheques = chequeConsumerService.findEnCashedChequeByDate(LocalDate.now());

        assertNotNull(enCashedCheques);
        assertEquals(3, enCashedCheques.getEnCashedCheques().size());

    }

}