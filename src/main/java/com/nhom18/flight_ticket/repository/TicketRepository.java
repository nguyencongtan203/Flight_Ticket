package com.nhom18.flight_ticket.repository;

import com.nhom18.flight_ticket.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Tickets,Integer> {
}
