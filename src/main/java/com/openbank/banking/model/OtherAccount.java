package com.openbank.banking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherAccount extends Account {
    @JsonProperty("id")
    private String id;
    @JsonProperty("holder")
    private Holder holder;
    @JsonProperty("number")
    private String number;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("IBAN")
    private String iban;
    @JsonProperty("swift_bic")
    private String swiftBic;
    private HashMap<String, Object> bank;
    @JsonProperty("metadata")
    private Metadata metadata;
}
