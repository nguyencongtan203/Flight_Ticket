package com.nhom18.flight_ticket.service;

import com.nhom18.flight_ticket.core.FlightStatus;
import com.nhom18.flight_ticket.core.TicketStatus;
import com.nhom18.flight_ticket.dto.request.TicketCreationRequest;
import com.nhom18.flight_ticket.dto.request.TicketUpdateRequest;
import com.nhom18.flight_ticket.entity.*;
import com.nhom18.flight_ticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightclassRepository flightclassRepository;
    @Autowired
    private FlightService flightService;
    public List<Tickets> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Tickets getById(int id){
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + id));
    }

    public Tickets updateStatusTicket(int id, TicketUpdateRequest request){
        Tickets ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + id));
        if(request.getStatus() != null) {
            ticket.setStatus(request.getStatus());
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public Tickets createTicket(TicketCreationRequest request) {
        Tickets ticket = new Tickets();
        Accounts account = accountRepository.findById(request.getBook_by_account_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Account Id"));
        Flights flight = flightRepository.findById(request.getFlight_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Flight Id"));
        Flightclasses flightclass = flightclassRepository.findById(request.getClass_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Account Id"));
        if(flight.getStatus() == FlightStatus.SCHEDULED){
            flight = flightService.updateDecreaseSeat(flight);
            ticket.setAccount(account);
            ticket.setFlightclass(flightclass);
            ticket.setFlight(flight);
            ticket.setName(request.getName());
            ticket.setPhone_number(request.getPhone_number());
            ticket.setPrice(request.getPrice());
            ticket.setStatus(TicketStatus.BOOKED);
            ticket.setBooking_date(Timestamp.valueOf(LocalDateTime.now()));
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public void cancelTicket(int id){
        Tickets ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Ticket Id" + id));
        if(ticket.getStatus() != TicketStatus.CANCELLED){
            flightService.updateIncreaseSeat(ticket.getFlight());
            ticket.setStatus(TicketStatus.CANCELLED);
            ticketRepository.save(ticket);
        }
    }
}
