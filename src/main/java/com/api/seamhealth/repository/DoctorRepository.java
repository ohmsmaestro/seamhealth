package com.api.seamhealth.repository;

import com.api.seamhealth.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    Long countByEmailOrPhoneNumber(String email, String phone);
}
