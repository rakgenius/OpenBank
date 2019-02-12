package com.openbank.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String id;
    private String accountId;
    private String counterpartyAccount;
    private String counterpartyName;
    private String counterPartyLogoPath;
    private String instructedAmount;
    private String instructedCurrency;
    private String transactionAmount;
    private String transactionCurrency;
    private String transactionType;
    private String description;
}
