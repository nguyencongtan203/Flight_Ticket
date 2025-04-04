package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nhom18.flight_ticket.core.TicketStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticket_id;

    private Timestamp booking_date;

    private BigDecimal price;

    private TicketStatus status;

    @Column(name = "phone_number", unique = true)
    private String phone_number;

    private String name;

    @ManyToOne
    @JoinColumn(name = "book_by_account_id")
    @JsonBackReference
    private Accounts account;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonBackReference
    private Flightclasses flightclass;

    @ManyToOne
    @JoinColumn(name = "flight_id")
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

    public Timestamp getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Timestamp booking_date) {
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
