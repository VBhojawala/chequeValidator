package com.validator.chequeValidator.controller;

import com.validator.chequeValidator.service.ChequeProducerService;
import com.validator.chequeValidator.service.ValidationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.validator.model.Cheque;

import static com.validator.constants.ApiConstants.API_V_1;

@RestController
@RequestMapping(API_V_1)
@RequiredArgsConstructor
@Log4j2
public class ChequeValidatorController {

    @Autowired
    ValidationService validationService;

    @Autowired
    ChequeProducerService chequeProducerService;

    @PostMapping("validate")
    public ResponseEntity<String> validateAndSendCheque(@Valid @RequestBody Cheque cheque) {
        log.info("Received cheque validation request ");
        boolean isValid = validationService.validateCheque(cheque);
        if (isValid) {
            chequeProducerService.sendMessage(cheque);
        }

        log.info("Returning response ");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
