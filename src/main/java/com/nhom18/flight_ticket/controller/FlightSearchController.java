package com.nhom18.flight_ticket.controller;

import com.nhom18.flight_ticket.dto.response.FlightSearchResponse;
import com.nhom18.flight_ticket.service.FlightSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightSearchController {
    private final FlightSearchService flightSearchService;

    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightSearchResponse>> searchFlights(
            @RequestParam String departureId,
            @RequestParam String arrivalId,
            @RequestParam String outboundDate,
            @RequestParam(required = false) String returnDate) {
        List<FlightSearchResponse> flights = flightSearchService.searchFlights(departureId, arrivalId, outboundDate,
                returnDate);
        return ResponseEntity.ok(flights);
    }

}
