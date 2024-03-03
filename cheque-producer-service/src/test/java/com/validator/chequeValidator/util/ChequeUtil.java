package com.validator.chequeValidator.util;

import com.validator.chequeValidator.entity.Account;
import com.validator.model.Cheque;

import java.time.LocalDate;

public class ChequeUtil {

    public static Cheque createCheque() {
        Cheque cheque = new Cheque();
        cheque.setChequeNumber("1234567890123456");
        cheque.setIssuerBank("ICICI");
        cheque.setIssuerBankAccount("10023");
        cheque.setIssuerName("John Doe");
        cheque.setIssuerIFSC("123456789");
        cheque.setIssuerMICR("8937363667");
        cheque.setIssueDate(LocalDate.of(2024, 02, 29));
        cheque.setIssuedTo("Michael Mich");
        cheque.setIssuedToAccount("52356");
        cheque.setIssuedToBank("HDFC");
        cheque.setValidity(LocalDate.of(2024, 03, 10));
        return cheque;
    }

    public static Account createIssuerAccount() {
        Account account = new Account();
        account.setAccountNumber(10023L);
        account.setAccountHolderName("John Doe");
        account.setIfsc("123456789");
        account.setMicr("8937363667");
        account.setBankName("ICICI");
        return account;
    }

    public static Account createIssuedToAccount() {
        Account account = new Account();
        account.setAccountNumber(52356L);
        account.setAccountHolderName("Michael Mich");
        account.setIfsc("123456789");
        account.setMicr("8937363667");
        account.setBankName("HDFC");
        return account;
    }
}
