package com.openbank.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @JsonProperty("id")
    private String id;
    @JsonProperty("holders")
    private List<Holder> holders;
    @JsonProperty("number")
    private String number;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("IBAN")
    private String iban;
    @JsonProperty("swift_bic")
    private String swiftBic;
    private HashMap<String, Object> bank;
}
