package com.api.seamhealth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {
    private Long id;

    @JsonProperty("address")
    private String address;

    @JsonProperty("state")
    private String state;

    @JsonProperty("lga")
    private String lga;
}
