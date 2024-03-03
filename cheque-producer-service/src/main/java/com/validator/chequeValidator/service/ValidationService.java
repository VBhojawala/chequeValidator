package com.validator.chequeValidator.service;

import com.validator.chequeValidator.exception.InvalidChequeException;
import com.validator.chequeValidator.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.validator.model.Cheque;
import com.validator.chequeValidator.entity.Account;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ValidationService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean validateCheque(Cheque cheque) {
        if (!validateIssuer(cheque) || !validateIssuedTo(cheque))
            throw new InvalidChequeException(cheque.getChequeNumber() + " is invalid!");
        return true;
    }

    private boolean validateIssuer(Cheque cheque) {
        log.info("Validating Issuer account ");
        Optional<Account> issuerAccountOptional = accountRepository
                .findById(Long.valueOf(cheque.getIssuerBankAccount()));
        if (!issuerAccountOptional.isPresent())
            return false;

        Account issuerAccount = issuerAccountOptional.get();

        if (!issuerAccount.getAccountHolderName().equals(cheque.getIssuerName()))
            return false;

        if (!issuerAccount.getIfsc().equals(cheque.getIssuerIFSC()))
            return false;

        if (!issuerAccount.getMicr().equals(cheque.getIssuerMICR()))
            return false;

        if (!issuerAccount.getBankName().equals(cheque.getIssuerBank()))
            return false;
        log.info("Issuer is valid! ");
        return true;
    }

    private boolean validateIssuedTo(Cheque cheque) {
        log.info("Validating Issued to Account");

        Optional<Account> issuedToAccountOptional = accountRepository
                .findById(Long.valueOf(cheque.getIssuedToAccount()));

        if (!issuedToAccountOptional.isPresent())
            return false;

        Account issuedToAccount = issuedToAccountOptional.get();

        if (!issuedToAccount.getBankName().equals(cheque.getIssuedToBank()))
            return false;

        if (!issuedToAccount.getAccountHolderName().equals(cheque.getIssuedTo()))
            return false;

        log.info("Issued to Account is valid!");
        return true;
    }
}
