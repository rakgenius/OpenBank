package com.openbank.banking.service;

import com.openbank.banking.model.BankAccount;
import com.openbank.banking.model.Transaction;
import com.openbank.banking.model.TransactionEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class AccountMappingService {
    public List<BankAccount> getbankAccount(TransactionEntry transactionEntry) {

        List<BankAccount> bankAccountList = new ArrayList<>();

        for (Transaction transaction : transactionEntry.getTransactions()) {
            //log.info("==transaction id {}", transaction.getId());
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(transaction.getId());
            bankAccount.setAccountId(transaction.getThisAccount().getId());
            bankAccount.setCounterpartyAccount(transaction.getOtherAccount().getNumber());
            bankAccount.setCounterpartyName(transaction.getOtherAccount().getHolder().getName());
            bankAccount.setCounterPartyLogoPath(transaction.getOtherAccount().getMetadata().getImageUrl().orElse("N/A"));
            HashMap<String, Object> map = transaction.getDetails().getValue();
            bankAccount.setInstructedAmount((String)transaction.getDetails().getValue().get("amount"));
            bankAccount.setInstructedCurrency((String)transaction.getDetails().getValue().get("currency"));
            bankAccount.setTransactionAmount(bankAccount.getInstructedAmount());
            bankAccount.setTransactionType(transaction.getDetails().getType());
            bankAccount.setTransactionCurrency(bankAccount.getInstructedCurrency());
            bankAccount.setDescription(transaction.getDetails().getDescription());
            bankAccountList.add(bankAccount);
        }
        return bankAccountList;
    }
}
