package com.api.seamhealth.repository;

import com.api.seamhealth.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    Long countByEmailOrPhoneNumber(String email, String phone);

    Boolean existsByIdNotAndEmailAndPhoneNumber(Long id, String email, String phone);

    @Query(
            value = "select count(*)>0 from doctor where id<>?1 and (email=?2 and phone=?3)",
            nativeQuery = true
    )
    boolean checkifEmailandPhoneAssignedAlready(Long id, String email, String phone);
}
