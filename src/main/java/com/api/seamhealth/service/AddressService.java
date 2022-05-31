package com.api.seamhealth.service;

import com.api.seamhealth.dto.request.AddAddressRequest;
import com.api.seamhealth.dto.response.AddressResponse;

public interface AddressService {
    AddressResponse editDoctorAddress(Long addressId, AddAddressRequest request);
}
