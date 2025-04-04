package com.nhom18.flight_ticket.controller;

import com.nhom18.flight_ticket.dto.request.ApiResponse;
import com.nhom18.flight_ticket.entity.Airports;
import com.nhom18.flight_ticket.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    public ApiResponse<List<Airports>> getAll(){
        ApiResponse<List<Airports>> apiResponse = new ApiResponse<>();
        try {
            List<Airports> list = airportService.getAll();
            apiResponse.setResult(list);
            apiResponse.setCode(200);
            apiResponse.setMessage("Get Success");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error retrieving list airport: " + e.getMessage());
        }
        return apiResponse;
    }
}
