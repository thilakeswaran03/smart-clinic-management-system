package com.smartclinic.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    // Method returns available time slots for doctor on a given date (3 points)
    public List<String> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        // In a real application, you would query the database to check the doctor's schedule and existing appointments
        System.out.println("Fetching available time slots for Doctor ID: " + doctorId + " on " + date);
        
        // Mocking available slots for demonstration
        return List.of("09:00 AM", "10:00 AM", "01:00 PM", "03:30 PM");
    }

    // Method validates doctor login credentials and returns structured response (2 points)
    public Map<String, Object> validateLogin(String email, String password) {
        Map<String, Object> response = new HashMap<>();

        // In a real application, you would fetch the doctor by email and use BCrypt to verify the password hash
        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            
            // Mocking a successful validation
            response.put("status", "success");
            response.put("message", "Login successful");
            response.put("token", "mock.jwt.token.here");
            response.put("doctorId", 1L);
        } else {
            // Mocking a failed validation
            response.put("status", "error");
            response.put("message", "Invalid email or password");
        }

        return response;
    }
}
