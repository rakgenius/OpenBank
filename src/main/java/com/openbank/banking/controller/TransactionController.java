package com.openbank.banking.controller;

import com.openbank.banking.exception.BankException;
import com.openbank.banking.model.BankAccount;
import com.openbank.banking.model.TransactionEntry;
import com.openbank.banking.service.AccountMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class TransactionController {
    @Autowired
    AccountMappingService accountMappingService;

    @GetMapping("/list")
    public ResponseEntity getTransactions() throws Exception {
        String url = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TransactionEntry> responseEntity = null;
        try {
            responseEntity =
                    restTemplate.getForEntity(url, TransactionEntry.class);
        } catch (Exception e) {
            throw new BankException("Unable to find the transactions");
        }

        if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND ||
            responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST ||
            responseEntity.getStatusCode() == HttpStatus.FORBIDDEN ||
            responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            throw new BankException("Unable to find the transactions");
        }
        List<BankAccount> bankAccount = accountMappingService.getbankAccount(responseEntity.getBody());
        return ResponseEntity.ok(bankAccount);
    }
}
