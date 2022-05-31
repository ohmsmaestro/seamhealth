package com.api.seamhealth.service;

import com.api.seamhealth.dto.request.AddAddressRequest;
import com.api.seamhealth.dto.request.RegisterDoctorRequest;
import com.api.seamhealth.dto.response.AddressResponse;
import com.api.seamhealth.dto.response.DoctorResponse;
import com.api.seamhealth.model.Doctor;

import java.util.List;
import java.util.Map;

public interface DoctorService {
    DoctorResponse registerDoctor(RegisterDoctorRequest request);
    Map<String, Object> getDoctors(int page, int size);
    DoctorResponse deleteDoctor(Long id);
    DoctorResponse getDoctorById(Long id);
    DoctorResponse editDoctor(Long id, RegisterDoctorRequest request);

    AddressResponse editDoctorAddress(Long id, AddAddressRequest request);
}
