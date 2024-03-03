# Cheque Validator service

## System Design

![System Design](./docs/images/SystemDesign.svg)

### API : POST  /api/v1/validate
Request body :

```json
{
  "check-number": "1234567890123456",
  "issuer-bank": "ICICI",
  "issuer-bank-account": "10023",
  "issuer-name": "John Doe",
  "issuer-ifsc": "123456789",
  "issuer-micr": "8937363667",
  "issue-date": "02/29/24",
  "issued-to": "Michael Mich",
  "issued-to-account": "52356",
  "issued-to-bank": "HDFC",
  "validity": "03/10/24"
}
```



# Cheque Consumer service

### API : GET  /api/v1/cheque?date=03%2F03%2F24

Response : 
```json
{
  "enCashedCheques": [
    {
      "validity": "03/10/24",
      "check-number": "1234567890123456",
      "issuer-bank": "ICICI",
      "issuer-bank-account": "10023",
      "issuer-name": "John Doe",
      "issuer-ifsc": "123456789",
      "issuer-micr": "8937363667",
      "issue-date": "02/29/24",
      "issued-to": "Michael Mich",
      "issued-to-account": "52356",
      "issued-to-bank": "HDFC"
    }
  ]
}
```