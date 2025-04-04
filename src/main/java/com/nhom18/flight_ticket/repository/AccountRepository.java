package com.nhom18.flight_ticket.repository;

import com.nhom18.flight_ticket.entity.Accounts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
    Optional<Accounts> findByEmail(String email);
}
