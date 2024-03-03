package com.validator.chequeValidator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "ACCOUNT")
@Data
public class Account {

    @Id
    @Column(name = "ACCOUNT_NUMBER")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNumber;

    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "IFSC")
    private String ifsc;

    @Column(name = "MICR")
    private String micr;

    @Column(name = "START_DATE")
    private Date startDate;
}
