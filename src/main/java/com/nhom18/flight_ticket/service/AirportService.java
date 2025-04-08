package com.nhom18.flight_ticket.service;

import com.nhom18.flight_ticket.entity.Airports;
import com.nhom18.flight_ticket.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airports> getAll(){
        return airportRepository.findAll();
    }
}
