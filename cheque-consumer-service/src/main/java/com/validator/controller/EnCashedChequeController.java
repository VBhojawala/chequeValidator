package com.validator.controller;

import com.validator.model.EnCashedCheques;
import com.validator.service.ChequeConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.validator.constants.ApiConstants.API_V_1;

@RestController
@RequestMapping(API_V_1)
public class EnCashedChequeController {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy").localizedBy(Locale.US);

    @Autowired
    private ChequeConsumerService chequeConsumerService;

    @GetMapping("cheque")
    public ResponseEntity<EnCashedCheques> getEnCashedChequeByDate(@RequestParam String date) {
        LocalDate queryDate = LocalDate.parse(date, formatter);
        EnCashedCheques enCashedCheques = chequeConsumerService.findEnCashedChequeByDate(queryDate);
        return new ResponseEntity<>(enCashedCheques, HttpStatus.OK);
    }

}
