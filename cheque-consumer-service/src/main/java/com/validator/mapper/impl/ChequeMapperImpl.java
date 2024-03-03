package com.validator.mapper.impl;

import com.validator.entity.EncashedCheque;
import com.validator.mapper.ChequeMapper;
import com.validator.model.Cheque;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ChequeMapperImpl implements ChequeMapper {
    @Override
    public EncashedCheque modelToEntity(Cheque cheque) {
        if (cheque == null)
            return null;

        EncashedCheque encashedCheque = new EncashedCheque();

        encashedCheque.setChequeNumber(cheque.getChequeNumber());
        encashedCheque.setIssuerBank(cheque.getIssuerBank());
        encashedCheque.setIssuerBankAccount(cheque.getIssuerBankAccount());
        encashedCheque.setIssuerName(cheque.getIssuerName());
        encashedCheque.setIssuerIFSC(cheque.getIssuerIFSC());
        encashedCheque.setIssuerMICR(cheque.getIssuerMICR());
        encashedCheque.setIssueDate(cheque.getIssueDate());
        encashedCheque.setIssuedTo(cheque.getIssuedTo());
        encashedCheque.setIssuedToAccount(cheque.getIssuedToAccount());
        encashedCheque.setIssuedToBank(cheque.getIssuedToBank());
        encashedCheque.setValidity(cheque.getValidity());
        encashedCheque.setEnCashedDate(LocalDate.now());

        return encashedCheque;
    }

    @Override
    public Cheque entityToModel(EncashedCheque encashedCheque) {
        if (encashedCheque == null)
            return null;

        Cheque cheque = new Cheque();
        cheque.setChequeNumber(encashedCheque.getChequeNumber());
        cheque.setIssuerBank(encashedCheque.getIssuerBank());
        cheque.setIssuerBankAccount(encashedCheque.getIssuerBankAccount());
        cheque.setIssuerName(encashedCheque.getIssuerName());
        cheque.setIssuerIFSC(encashedCheque.getIssuerIFSC());
        cheque.setIssuerMICR(encashedCheque.getIssuerMICR());
        cheque.setIssueDate(encashedCheque.getIssueDate());
        cheque.setIssuedTo(encashedCheque.getIssuedTo());
        cheque.setIssuedToAccount(encashedCheque.getIssuedToAccount());
        cheque.setIssuedToBank(encashedCheque.getIssuedToBank());
        cheque.setValidity(encashedCheque.getValidity());

        return cheque;
    }
}
