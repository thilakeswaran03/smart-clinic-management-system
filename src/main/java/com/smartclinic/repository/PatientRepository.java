package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Method retrieves patient by email using derived or custom query (2 points)
    Optional<Patient> findByEmail(String email);

    // Method retrieves patient using either email or phone number (2 points)
    Optional<Patient> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
