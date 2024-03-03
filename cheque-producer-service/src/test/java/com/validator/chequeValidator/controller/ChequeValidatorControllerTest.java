package com.validator.chequeValidator.controller;

import com.validator.chequeValidator.service.ChequeProducerService;
import com.validator.chequeValidator.service.ValidationService;
import com.validator.chequeValidator.util.ChequeUtil;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ChequeValidatorControllerTest {

    @Mock
    ValidationService validationService;

    @Mock
    ChequeProducerService chequeProducerService;

    @InjectMocks
    ChequeValidatorController chequeValidatorController;

    @Test
    void validateAndSendCheque() {
        Mockito.when(validationService.validateCheque(Mockito.any())).thenReturn(true);

        ResponseEntity<String> response = chequeValidatorController.validateAndSendCheque(ChequeUtil.createCheque());

        Mockito.verify(validationService, Mockito.times(1)).validateCheque(Mockito.any());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}