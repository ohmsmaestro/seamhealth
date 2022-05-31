package com.api.seamhealth.controller;

import com.api.seamhealth.dto.request.AddAddressRequest;
import com.api.seamhealth.dto.request.RegisterDoctorRequest;
import com.api.seamhealth.dto.response.AddressResponse;
import com.api.seamhealth.dto.response.DoctorResponse;
import com.api.seamhealth.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PutMapping(value = "/{address_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressResponse> editDoctorAddress(@PathVariable(value = "address_id") Long address_id,  @RequestBody AddAddressRequest request){
        AddressResponse response = addressService.editDoctorAddress(address_id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
