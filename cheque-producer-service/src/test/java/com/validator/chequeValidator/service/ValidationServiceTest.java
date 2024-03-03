package com.validator.chequeValidator.service;

import com.validator.chequeValidator.exception.InvalidChequeException;
import com.validator.chequeValidator.repository.AccountRepository;
import com.validator.chequeValidator.util.ChequeUtil;
import com.validator.model.Cheque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private ValidationService validationService;

    @BeforeEach
    void setup(){
        when(accountRepository.findById(10023L)).thenReturn(Optional.of(ChequeUtil.createIssuerAccount()));
    }

    @Test
    void testValidateCorrectCheque(){
        when(accountRepository.findById(52356L)).thenReturn(Optional.of(ChequeUtil.createIssuedToAccount()));
        assertTrue(validationService.validateCheque(ChequeUtil.createCheque()));
    }

    @Test
    void testValidateInValidCheque() {
        Cheque cheque = ChequeUtil.createCheque();
        cheque.setIssuerBank("BOI");
        assertThrows(InvalidChequeException.class, () -> validationService.validateCheque(cheque));
    }
}