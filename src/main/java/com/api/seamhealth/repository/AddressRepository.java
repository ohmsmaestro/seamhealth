package com.api.seamhealth.repository;

import com.api.seamhealth.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
