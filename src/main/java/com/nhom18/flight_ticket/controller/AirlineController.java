package com.nhom18.flight_ticket.controller;

import com.nhom18.flight_ticket.dto.request.ApiResponse;
import com.nhom18.flight_ticket.entity.Airlines;
import com.nhom18.flight_ticket.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airlines")
    public ApiResponse<List<Airlines>> getAll(){
        ApiResponse<List<Airlines>> apiResponse = new ApiResponse<>();
        try {
            List<Airlines> list = airlineService.getAll();
            apiResponse.setResult(list);
            apiResponse.setCode(200);
            apiResponse.setMessage("Get Success");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error retrieving list airline: " + e.getMessage());
        }
        return apiResponse;
    }
}
