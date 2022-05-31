package com.api.seamhealth.repository;

import com.api.seamhealth.model.Address;
import com.api.seamhealth.model.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DoctorRepositoryTest {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AddressRepository addressRepository;
    @Test
    @Transactional
    public void registerDoctor(){

        Address address = Address.builder()
                .lga("Okene")
                .state("Kogi")
                .build();

        Doctor doctor = Doctor.builder()
                .email("omenesa2013")
                .address(address)
                .phoneNumber("0908866666")
                .firstName("Omenesa")
                .lastName("Muhammed")
                .build();

        address.setDoctor(doctor);

        //addressRepository.save(address);



        //System.out.println("doctor1 = " + doctor1);


    }

    @Transactional
    @Test
    public void getDoctorById(){
        Doctor referenceById = doctorRepository.getReferenceById(1l);

        System.out.println("referenceById = " + referenceById);
       // Optional<Doctor> doctor = doctorRepository.findById(1l);
//        if(doctor.isPresent()){
//            //System.out.println("doctor = " + doctor.get());
//        }
    }
}