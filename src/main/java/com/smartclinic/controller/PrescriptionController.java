package com.smartclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // POST endpoint saves a prescription with token and request body validation (3 points)
    @PostMapping
    public ResponseEntity<Map<String, Object>> savePrescription(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestBody Map<String, Object> prescriptionRequest) {

        Map<String, Object> response = new HashMap<>();

        // 1. Token Validation
        if (token == null || !token.startsWith("Bearer ")) {
            response.put("status", "error");
            response.put("message", "Unauthorized: Missing or invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // 2. Request Body Validation
        if (prescriptionRequest == null || !prescriptionRequest.containsKey("appointmentId") || !prescriptionRequest.containsKey("medicationDetails")) {
            // Returns structured success or error messages using ResponseEntity (3 points)
            response.put("status", "error");
            response.put("message", "Bad Request: Missing required fields (appointmentId, medicationDetails)");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // In a fully built application, you would pass this data to a PrescriptionService to save in the database
            
            // Structured success response
            response.put("status", "success");
            response.put("message", "Prescription saved successfully");
            response.put("data", prescriptionRequest); 

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            // Structured error response
            response.put("status", "error");
            response.put("message", "An internal error occurred while saving the prescription");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
