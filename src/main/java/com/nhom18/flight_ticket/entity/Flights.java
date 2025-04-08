package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nhom18.flight_ticket.core.FlightStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flight_id;
    @Column(name = "flight_number", unique = true)
    private int flight_number;
    private Timestamp departure_time;

    private Timestamp arrival_time;

    private int total_seats;

    private int available_seats;

    private BigDecimal price;

    private FlightStatus status;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Tickets> listTickets;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    @JsonBackReference
    private Airlines airline;

    @ManyToOne
    @JoinColumn(name = "origin_airport")
    @JsonBackReference
    private Airports origin_airport;

    @ManyToOne
    @JoinColumn(name = "des_airport")
    @JsonBackReference
    private Airports des_airport;

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public Timestamp getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Timestamp departure_time) {
        this.departure_time = departure_time;
    }

    public Timestamp getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Timestamp arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public List<Tickets> getListTickets() {
        return listTickets;
    }

    public void setListTickets(List<Tickets> ListTickets) {
        listTickets = ListTickets;
    }

    public Airlines getAirline() {
        return airline;
    }

    public void setAirline(Airlines airline) {
        this.airline = airline;
    }

    public Airports getOrigin_airport() {
        return origin_airport;
    }

    public void setOrigin_airport(Airports origin_airport) {
        this.origin_airport = origin_airport;
    }

    public Airports getDes_airport() {
        return des_airport;
    }

    public void setDes_airport(Airports des_airport) {
        this.des_airport = des_airport;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }
}
