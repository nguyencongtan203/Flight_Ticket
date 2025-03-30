package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nhom18.flight_ticket.core.TicketStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticket_id;

    private Date booking_date;

    private BigDecimal price;

    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "book_by_account_id", insertable = false, updatable = false)
    @JsonBackReference
    private Accounts account;

    @ManyToOne
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    @JsonBackReference
    private Flightclasses flightclass;

    @ManyToOne
    @JoinColumn(name = "seat_id", insertable = false, updatable = false)
    @JsonBackReference
    private Seats seat;

    @ManyToOne
    @JoinColumn(name = "passenger_id", insertable = false, updatable = false)
    @JsonBackReference
    private Passengers passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id", insertable = false, updatable = false)
    @JsonBackReference
    private Flights flight;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Payments> listPayments;

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public Flightclasses getFlightclass() {
        return flightclass;
    }

    public void setFlightclass(Flightclasses flightclass) {
        this.flightclass = flightclass;
    }

    public Seats getSeat() {
        return seat;
    }

    public void setSeat(Seats seat) {
        this.seat = seat;
    }

    public Passengers getPassenger() {
        return passenger;
    }

    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public List<Payments> getListPayments() {
        return listPayments;
    }

    public void setListPayments(List<Payments> ListPayments) {
        listPayments = ListPayments;
    }
}
