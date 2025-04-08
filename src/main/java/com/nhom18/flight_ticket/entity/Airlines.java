package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Airlines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airline_id;

    private String airline_name;

    private String country;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Flights> listFlights;

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Flights> getListFlights() {
        return listFlights;
    }

    public void setListFlights(List<Flights> ListFlights) {
        listFlights = ListFlights;
    }
}
