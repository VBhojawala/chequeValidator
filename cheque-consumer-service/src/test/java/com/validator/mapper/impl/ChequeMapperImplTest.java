package com.validator.mapper.impl;

import com.validator.entity.EncashedCheque;
import com.validator.model.Cheque;
import com.validator.util.EnCashedChequeUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChequeMapperImplTest {

    ChequeMapperImpl mapper = new ChequeMapperImpl();

    @Test
    void testModelToEntity() {
        Cheque cheque = EnCashedChequeUtil.createCheque();
        EncashedCheque encashedCheque = mapper.modelToEntity(cheque);

        assertEquals(cheque.getChequeNumber(), encashedCheque.getChequeNumber());
        assertEquals(cheque.getIssuerBank(), encashedCheque.getIssuerBank());
        assertEquals(cheque.getIssuerBankAccount(), encashedCheque.getIssuerBankAccount());
        assertEquals(cheque.getIssuerName(), encashedCheque.getIssuerName());
        assertEquals(cheque.getIssuerIFSC(), encashedCheque.getIssuerIFSC());
        assertEquals(cheque.getIssuerMICR(), encashedCheque.getIssuerMICR());
        assertEquals(cheque.getIssueDate(), encashedCheque.getIssueDate());
        assertEquals(cheque.getIssuedTo(), encashedCheque.getIssuedTo());
        assertEquals(cheque.getIssuedToAccount(), encashedCheque.getIssuedToAccount());
        assertEquals(cheque.getIssuedToBank(), encashedCheque.getIssuedToBank());
        assertEquals(cheque.getValidity(), encashedCheque.getValidity());
        assertNotNull(encashedCheque.getEnCashedDate());
    }

    @Test
    void testEntityToModel() {
        EncashedCheque encashedCheque = EnCashedChequeUtil.createEnCashedCheque();
        Cheque cheque = mapper.entityToModel(encashedCheque);

        assertEquals(encashedCheque.getChequeNumber(), cheque.getChequeNumber());
        assertEquals(encashedCheque.getIssuerBank(), cheque.getIssuerBank());
        assertEquals(encashedCheque.getIssuerBankAccount(), cheque.getIssuerBankAccount());
        assertEquals(encashedCheque.getIssuerName(), cheque.getIssuerName());
        assertEquals(encashedCheque.getIssuerIFSC(), cheque.getIssuerIFSC());
        assertEquals(encashedCheque.getIssuerMICR(), cheque.getIssuerMICR());
        assertEquals(encashedCheque.getIssueDate(), cheque.getIssueDate());
        assertEquals(encashedCheque.getIssuedTo(), cheque.getIssuedTo());
        assertEquals(encashedCheque.getIssuedToAccount(), cheque.getIssuedToAccount());
        assertEquals(encashedCheque.getIssuedToBank(), cheque.getIssuedToBank());
        assertEquals(encashedCheque.getValidity(), cheque.getValidity());
    }

}