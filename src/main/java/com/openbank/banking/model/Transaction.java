package com.openbank.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @JsonProperty("id")
    private String id;
    @JsonProperty("this_account")
    private Account thisAccount;
    @JsonProperty("other_account")
    private OtherAccount otherAccount;
    @JsonProperty("details")
    private Details details;
}
