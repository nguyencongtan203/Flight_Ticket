package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airport_id;

    private String airport_name;

    private String city;

    private String country;

    private String timezone;

    private String code;

    @OneToMany(mappedBy = "origin_airport", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Flights> listOriginFlights;

    @OneToMany(mappedBy = "des_airport", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Flights> listDesFlights;

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<Flights> getListOriginFlights() {
        return listOriginFlights;
    }

    public void setListOriginFlights(List<Flights> ListOriginFlights) {
        listOriginFlights = ListOriginFlights;
    }

    public List<Flights> getListDesFlights() {
        return listDesFlights;
    }

    public void setListDesFlights(List<Flights> ListDesFlights) {
        listDesFlights = ListDesFlights;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
