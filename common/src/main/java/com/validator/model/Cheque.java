package com.validator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Validated
public class Cheque implements Serializable {

    @JsonProperty("check-number")
    @NotNull(message = "check-number can not be null")
    private String chequeNumber;

    @JsonProperty("issuer-bank")
    @NotNull(message = "issuer-bank can not be null")
    private String issuerBank;

    @JsonProperty("issuer-bank-account")
    @NotNull(message = "issuer-bank-account can not be null")
    private String issuerBankAccount;

    @JsonProperty("issuer-name")
    @NotNull(message = "issuer-name can not be null")
    private String issuerName;

    @JsonProperty("issuer-ifsc")
    @NotNull(message = "issuer-ifsc can not be null")
    private String issuerIFSC;

    @JsonProperty("issuer-micr")
    @NotNull(message = "issuer-micr can not be null")
    private String issuerMICR;

    @JsonProperty("issue-date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yy")
    @NotNull(message = "issue-date can not be null")
    @PastOrPresent
    private LocalDate issueDate;

    @JsonProperty("issued-to")
    @NotNull(message = "issued-to can not be null")
    private String issuedTo;

    @JsonProperty("issued-to-account")
    @NotNull(message = "issued-to-account can not be null")
    private String issuedToAccount;

    @JsonProperty("issued-to-bank")
    @NotNull(message = "issued-to-bank can not be null")
    private String issuedToBank;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yy")
    @NotNull(message = "validity can not be null")
    @FutureOrPresent
    private LocalDate validity;

}
