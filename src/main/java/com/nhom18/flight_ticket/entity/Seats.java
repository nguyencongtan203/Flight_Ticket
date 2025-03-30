package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_id;

    private String seat_number;

    private int is_booked;

    @ManyToOne
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    @JsonBackReference
    private Flightclasses flightclass;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Tickets> listTickets;

    @ManyToOne
    @JoinColumn(name = "flight_id", insertable = false, updatable = false)
    @JsonBackReference
    private Flights flight;

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public int getIs_booked() {
        return is_booked;
    }

    public void setIs_booked(int is_booked) {
        this.is_booked = is_booked;
    }

    public Flightclasses getFlightclass() {
        return flightclass;
    }

    public void setFlightclass(Flightclasses flightclass) {
        this.flightclass = flightclass;
    }

    public List<Tickets> getListTickets() {
        return listTickets;
    }

    public void setListTickets(List<Tickets> ListTickets) {
        listTickets = ListTickets;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }
}
