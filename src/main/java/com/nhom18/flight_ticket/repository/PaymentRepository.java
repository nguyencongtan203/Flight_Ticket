package com.nhom18.flight_ticket.repository;

import com.nhom18.flight_ticket.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Integer> {
}
