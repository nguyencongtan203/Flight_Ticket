package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Flightclasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;

    private String class_name;

    private BigDecimal price_ratio;

    @OneToMany(mappedBy = "flightclass", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Seats> listSeats;

    @OneToMany(mappedBy = "flightclass", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Tickets> listTickets;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public BigDecimal getPrice_ratio() {
        return price_ratio;
    }

    public void setPrice_ratio(BigDecimal price_ratio) {
        this.price_ratio = price_ratio;
    }

    public List<Seats> getListSeats() {
        return listSeats;
    }

    public void setListSeats(List<Seats> ListSeats) {
        listSeats = ListSeats;
    }

    public List<Tickets> getListTickets() {
        return listTickets;
    }

    public void setListTickets(List<Tickets> ListTickets) {
        listTickets = ListTickets;
    }
}
