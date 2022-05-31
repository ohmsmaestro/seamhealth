package com.api.seamhealth.service.impl;


import com.api.seamhealth.dto.request.AddAddressRequest;
import com.api.seamhealth.dto.request.RegisterDoctorRequest;
import com.api.seamhealth.dto.response.AddressResponse;
import com.api.seamhealth.dto.response.DoctorResponse;
import com.api.seamhealth.exception.ApiException;
import com.api.seamhealth.model.Address;
import com.api.seamhealth.model.Doctor;
import com.api.seamhealth.repository.AddressRepository;
import com.api.seamhealth.repository.DoctorRepository;
import com.api.seamhealth.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper, AddressRepository addressRepository) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
        this.addressRepository = addressRepository;
    }


    @Transactional
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

    @Override
    public Map<String, Object> getDoctors(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<Doctor> doctors = new ArrayList<>();
        Page<Doctor> pageEmployees = doctorRepository.findAll(paging);
        doctors = pageEmployees.getContent();

        if (doctors.size() == 0) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "No doctors found");
        }

        List<DoctorResponse> employeesResponse = doctors
                .stream()
                .map(sc -> modelMapper.map(sc, DoctorResponse.class))
                .collect(Collectors.toList());

        Map<String, Object> doctorsListPagination = new HashMap<>();
        doctorsListPagination.put("doctors", employeesResponse);
        doctorsListPagination.put("current_page", pageEmployees.getNumber());
        doctorsListPagination.put("total_doctor", pageEmployees.getTotalElements());
        doctorsListPagination.put("total_page", pageEmployees.getTotalPages());
        return doctorsListPagination;
    }

    @Override
    public DoctorResponse deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "The doctor does not exist"));
        doctorRepository.delete(doctor);
        return modelMapper.map(doctor, DoctorResponse.class);
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "The doctor does not exist"));
        return modelMapper.map(doctor, DoctorResponse.class);
    }

    @Override
    public DoctorResponse editDoctor(Long doctorId, RegisterDoctorRequest request) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "The doctor does not exist"));

        Boolean emailOrPhoneExists = doctorRepository.existsByIdNotAndEmailAndPhoneNumber(doctorId, request.getEmail(), request.getPhoneNumber());
        if(emailOrPhoneExists){
            throw new ApiException(HttpStatus.CONFLICT, "Email or phone already exist");
        }

        doctor.setEmail(request.getEmail());
        doctor.setFirstName(request.getFirstName());
        doctor.setLastName(request.getLastName());
        doctor.setPhoneNumber(request.getPhoneNumber());

        Address address = doctor.getAddress();
        address.setAddress(request.getAddress());
        address.setState(request.getState());
        address.setLga(request.getLga());

        doctor.setAddress(address);
        return modelMapper.map(doctorRepository.save(doctor), DoctorResponse.class);
    }

    @Override
    public AddressResponse editDoctorAddress(Long addressId, AddAddressRequest request) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "The address does not exist"));
        address.setLga(request.getLga());
        address.setState(request.getState());

        return modelMapper.map(addressRepository.save(address), AddressResponse.class);
    }
}
