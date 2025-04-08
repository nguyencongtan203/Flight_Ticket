package com.nhom18.flight_ticket.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhom18.flight_ticket.core.FlightStatus;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FlightCreationRequest {
    private int airline_id;
    private int flight_number;
    private int origin_airport;
    private int des_airport;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp departure_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp arrival_time;
    private int total_seats;
    private int available_seats;
    private BigDecimal price;
    private FlightStatus status;

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public int getOrigin_airport() {
        return origin_airport;
    }

    public void setOrigin_airport(int origin_airport) {
        this.origin_airport = origin_airport;
    }

    public int getDes_airport() {
        return des_airport;
    }

    public void setDes_airport(int des_airport) {
        this.des_airport = des_airport;
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
}
