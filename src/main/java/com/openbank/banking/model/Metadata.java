package com.openbank.banking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
    @JsonProperty("public_alias")
    private String publicAlias;
    @JsonProperty("private_alias")
    private String privateAlias;
    @JsonProperty("more_info")
    private String moreInfo;
    @JsonProperty("URL")
    private String url;
    @JsonProperty("image_URL")
    private Optional<String> imageUrl;
    @JsonProperty("open_corporates_URL")
    private String openCorporatesUrl;
    @JsonProperty("corporate_location")
    private String corporateLocation;
    @JsonProperty("physical_location")
    private String physicalLocation;

}
