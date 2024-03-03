package com.validator.chequeValidator.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
    @Mock
    BindingResult bindingResult;
    @Mock
    MethodArgumentNotValidException manvEx;

    @Test
    void testHandleMethodArgumentNotValid(){
        when(manvEx.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getAllErrors()).thenReturn(new ArrayList<>());
        ResponseEntity<Object>  responseEntity = globalExceptionHandler.handleMethodArgumentNotValid(manvEx);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void testHandleInvalidChequeException() {
        InvalidChequeException ex = new InvalidChequeException("Cheque 132 is invalid!");
        ResponseEntity<String> responseEntity = globalExceptionHandler.handleInvalidChequeException(ex);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Cheque 132 is invalid!", responseEntity.getBody());
    }

}