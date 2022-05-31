package com.api.seamhealth.dto.request;

import com.api.seamhealth.model.Doctor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddAddressRequest {
    private Long Id;

    @NotNull(message = "address name required")
    @NotBlank(message = "address name required")
    @JsonProperty("address")
    private String address;

    @NotNull(message = "state required")
    @NotBlank(message = "state required")
    @JsonProperty("state")
    private String state;

    @NotNull(message = "lga required")
    @NotBlank(message = "lga required")
    @JsonProperty("lga")
    private String lga;

    private Doctor doctor;
}
