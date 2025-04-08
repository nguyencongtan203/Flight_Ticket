package com.nhom18.flight_ticket.service;

import com.nhom18.flight_ticket.core.FlightStatus;
import com.nhom18.flight_ticket.dto.request.FlightCreationRequest;
import com.nhom18.flight_ticket.dto.request.FlightUpdateRequest;
import com.nhom18.flight_ticket.entity.Airlines;
import com.nhom18.flight_ticket.entity.Airports;
import com.nhom18.flight_ticket.entity.Flights;
import com.nhom18.flight_ticket.repository.AirlineRepository;
import com.nhom18.flight_ticket.repository.AirportRepository;
import com.nhom18.flight_ticket.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private AirportRepository airportRepository;

    public Flights createFlight(FlightCreationRequest request){
        Flights flight = new Flights();
        Airlines airline = airlineRepository.findById(request.getAirline_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Airline Id"));
        Airports originAirport = airportRepository.findById(request.getOrigin_airport())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Origin AirPort Id"));
        Airports desAirport = airportRepository.findById(request.getOrigin_airport())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Des Airport Id"));
        flight.setAirline(airline);
        flight.setFlight_number(request.getFlight_number());
        flight.setOrigin_airport(originAirport);
        flight.setDes_airport(desAirport);
        flight.setArrival_time(request.getArrival_time());
        flight.setDeparture_time(request.getDeparture_time());
        flight.setTotal_seats(request.getTotal_seats());
        flight.setAvailable_seats(request.getAvailable_seats());
        flight.setPrice(request.getPrice());
        flight.setStatus(request.getStatus());
        flightRepository.save(flight);
        return flight;
    }
    public Flights updateStatusFlight(int id, FlightUpdateRequest request){
        Flights flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Flight Id"));
        flight.setStatus(request.getStatus());
        return flightRepository.save(flight);
    }

    public Flights updateIncreaseSeat(Flights flight){
        flight.setAvailable_seats(flight.getAvailable_seats() + 1);
        if(flight.getStatus() == FlightStatus.FULLY_BOOKED){
            flight.setStatus(FlightStatus.SCHEDULED);
        }
        return flightRepository.save(flight);
    }

    public Flights updateDecreaseSeat(Flights flight){
        flight.setAvailable_seats(flight.getAvailable_seats() - 1);
        if(flight.getStatus() == FlightStatus.SCHEDULED && flight.getAvailable_seats() == 0){
            flight.setStatus(FlightStatus.FULLY_BOOKED);
        }
        return flightRepository.save(flight);
    }
}
