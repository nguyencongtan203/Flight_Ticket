package com.nhom18.flight_ticket.controller;

import com.nhom18.flight_ticket.dto.request.ApiResponse;
import com.nhom18.flight_ticket.dto.request.FlightCreationRequest;
import com.nhom18.flight_ticket.dto.request.FlightUpdateRequest;
import com.nhom18.flight_ticket.entity.Flights;
import com.nhom18.flight_ticket.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/flight")
    public ApiResponse<Flights> createFlight(@RequestBody FlightCreationRequest request){
        ApiResponse<Flights> apiResponse = new ApiResponse<>();
        try {
            Flights flight = flightService.createFlight(request);
            apiResponse.setCode(200);
            apiResponse.setResult(flight);
            apiResponse.setMessage("Flight created successfully");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error creating flight: " + e.getMessage());
        }
        return apiResponse;
    }

    @PutMapping("update/status/{id}")
    public ApiResponse<Flights> updateStatus(@PathVariable("id") int id, @RequestBody FlightUpdateRequest request){
        ApiResponse<Flights> apiResponse = new ApiResponse<>();
        try {
            Flights flight = flightService.updateStatusFlight(id,request);
            apiResponse.setCode(200);
            apiResponse.setResult(flight);
            apiResponse.setMessage("Status flight updated successfully");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error updating status flight: " + e.getMessage());
        }
        return apiResponse;
    }
}
