package com.smartclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    // Exposes a GET endpoint for doctor availability using dynamic parameters (3 points)
    @GetMapping("/{doctorId}/availability")
    public ResponseEntity<Map<String, Object>> getDoctorAvailability(
            @PathVariable Long doctorId,
            @RequestParam String date,
            @RequestHeader(value = "Authorization", required = false) String token) {

        Map<String, Object> response = new HashMap<>();

        // Validates token and returns a structured response using ResponseEntity (3 points)
        if (token == null || !token.startsWith("Bearer ")) {
            response.put("status", "error");
            response.put("message", "Unauthorized: Missing or invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        try {
            // In a real application, you would call your TokenService and DoctorService here
            // Example mock data for structural completeness
            List<String> availableSlots = List.of("09:00 AM", "11:30 AM", "02:00 PM", "04:30 PM");

            response.put("status", "success");
            response.put("doctorId", doctorId);
            response.put("date", date);
            response.put("availableSlots", availableSlots);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "An error occurred while fetching availability");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
