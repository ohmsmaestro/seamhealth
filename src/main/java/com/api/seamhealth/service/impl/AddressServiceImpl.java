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
import com.api.seamhealth.service.AddressService;
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
public class AddressServiceImpl implements AddressService {
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    public AddressServiceImpl(ModelMapper modelMapper, AddressRepository addressRepository) {
        this.modelMapper = modelMapper;
        this.addressRepository = addressRepository;
    }


    @Transactional
    @Override
    public AddressResponse editDoctorAddress(Long addressId, AddAddressRequest request) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "The address does not exist"));
        address.setAddress(request.getAddress());
        address.setLga(request.getLga());
        address.setState(request.getState());

        return modelMapper.map(addressRepository.save(address), AddressResponse.class);
    }
}
