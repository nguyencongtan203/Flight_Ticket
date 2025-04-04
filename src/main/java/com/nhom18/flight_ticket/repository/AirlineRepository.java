package com.nhom18.flight_ticket.repository;

import com.nhom18.flight_ticket.entity.Airlines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airlines,Integer> {
}
