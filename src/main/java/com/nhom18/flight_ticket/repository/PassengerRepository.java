package com.nhom18.flight_ticket.repository;

import com.nhom18.flight_ticket.entity.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passengers,Integer> {
}
