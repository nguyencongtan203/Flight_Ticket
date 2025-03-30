package com.nhom18.flight_ticket.service;

import com.nhom18.flight_ticket.dto.request.TicketUpdateRequest;
import com.nhom18.flight_ticket.entity.Tickets;
import com.nhom18.flight_ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

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
}
