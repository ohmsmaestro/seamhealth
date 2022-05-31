package com.api.seamhealth.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RegisterDoctorRequest {
    private Long Id;

    @NotNull(message = "first name required")
    @NotBlank(message = "first name required")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(message = "last name required")
    @NotBlank(message = "last name required")
    @JsonProperty("last_name")
    private String lastName;

    @NotNull(message = "email required")
    @NotBlank(message = "email required")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "phone required")
    @NotBlank(message = "phone required")
    @JsonProperty("phone")
    private String phoneNumber;

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
}
