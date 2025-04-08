package com.nhom18.flight_ticket.repository;

import com.nhom18.flight_ticket.entity.Airports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airports,Integer> {
}
