package com.validator.controller;

import com.validator.model.EnCashedCheques;
import com.validator.service.ChequeConsumerService;
import com.validator.util.EnCashedChequeUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnCashedChequeControllerTest {

    @Mock
    private ChequeConsumerService chequeConsumerService;

    @InjectMocks
    EnCashedChequeController enCashedChequeController;

    @Test
    void testGetEnCashedChequeByDate(){
        when(chequeConsumerService.findEnCashedChequeByDate(any())).thenReturn(EnCashedChequeUtil.createEnCashedCheques());
        ResponseEntity<EnCashedCheques> responseEntity = enCashedChequeController.getEnCashedChequeByDate("03/03/24");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(3, responseEntity.getBody().getEnCashedCheques().size());

    }

}