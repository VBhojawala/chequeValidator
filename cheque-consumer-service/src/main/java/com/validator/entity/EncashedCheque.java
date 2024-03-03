package com.validator.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "ENCASHED_CHEQUE")
@Data
public class EncashedCheque {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "idGen", strategy = "increment")
    @GeneratedValue(generator = "idGen")
    private Integer id;

    @Column(name = "CHEQUE_NO")
    private String chequeNumber;

    @Column(name = "ISSUER_BANK")
    private String issuerBank;

    @Column(name = "ISSUER_BANK_ACCOUNT")
    private String issuerBankAccount;

    @Column(name = "ISSUER_NAME")
    private String issuerName;

    @Column(name = "ISSUER_IFSC")
    private String issuerIFSC;

    @Column(name = "ISSUER_MICR")
    private String issuerMICR;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "ISSUED_TO")
    private String issuedTo;

    @Column(name = "ISSUED_TO_ACCOUNT")
    private String issuedToAccount;

    @Column(name = "ISSUED_TO_BANK")
    private String issuedToBank;

    @Column(name = "VALIDITY")
    private LocalDate validity;

    @Column(name = "ENCASHED_DATE")
    private LocalDate enCashedDate;

}
