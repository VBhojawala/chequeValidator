package com.validator.util;

import com.validator.entity.EncashedCheque;
import com.validator.model.Cheque;
import com.validator.model.EnCashedCheques;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnCashedChequeUtil {

    public static EnCashedCheques createEnCashedCheques() {
        EnCashedCheques encashedCheques = new EnCashedCheques();
        List<Cheque> chequeList = new ArrayList<>();
        chequeList.add(createCheque());
        chequeList.add(createCheque());
        chequeList.add(createCheque());
        encashedCheques.setEnCashedCheques(chequeList);
        return encashedCheques;
    }

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

    public static EncashedCheque createEnCashedCheque() {
        EncashedCheque cheque = new EncashedCheque();
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
        cheque.setEnCashedDate(LocalDate.of(2024, 03, 03));
        return cheque;
    }

    public static List<EncashedCheque> createEnCashedChequesList() {
        List<EncashedCheque> chequeList = new ArrayList<>();
        chequeList.add(createEnCashedCheque());
        chequeList.add(createEnCashedCheque());
        chequeList.add(createEnCashedCheque());
        return chequeList;
    }
}
