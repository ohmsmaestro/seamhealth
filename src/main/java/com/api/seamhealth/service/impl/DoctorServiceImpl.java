package com.api.seamhealth.service.impl;


import com.api.seamhealth.dto.request.RegisterDoctorRequest;
import com.api.seamhealth.dto.response.DoctorResponse;
import com.api.seamhealth.exception.ApiException;
import com.api.seamhealth.model.Address;
import com.api.seamhealth.model.Doctor;
import com.api.seamhealth.repository.DoctorRepository;
import com.api.seamhealth.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }


    //@Transactional
    @Override
    public DoctorResponse registerDoctor(RegisterDoctorRequest request) {
        Long emailOrPhoneExists = doctorRepository.countByEmailOrPhoneNumber(request.getEmail(), request.getPhoneNumber());
        if(emailOrPhoneExists>0){
            throw new ApiException(HttpStatus.CONFLICT, "Email or phone already exist");
        }

        Address address = Address.builder()
                .state(request.getState())
                .address(request.getAddress())
                .lga(request.getLga())
                .build();

        Doctor doctor = Doctor.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .address(address)
                .build();

        Doctor created = doctorRepository.save(doctor);
        return modelMapper.map(created, DoctorResponse.class);
    }
}
