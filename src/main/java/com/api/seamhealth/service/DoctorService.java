package com.api.seamhealth.service;

import com.api.seamhealth.dto.request.RegisterDoctorRequest;
import com.api.seamhealth.dto.response.DoctorResponse;
import com.api.seamhealth.model.Doctor;

import java.util.List;

public interface DoctorService {
    DoctorResponse registerDoctor(RegisterDoctorRequest request);
    List<DoctorResponse> fetchAllDoctorsByPagination();
}
