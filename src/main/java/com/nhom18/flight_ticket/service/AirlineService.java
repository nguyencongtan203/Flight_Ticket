package com.nhom18.flight_ticket.service;

import com.nhom18.flight_ticket.entity.Airlines;
import com.nhom18.flight_ticket.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    public List<Airlines> getAll(){
        return airlineRepository.findAll();
    }
}
