package com.nhom18.flight_ticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nhom18.flight_ticket.core.PaymentMethod;
import com.nhom18.flight_ticket.core.PaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    private BigDecimal amount;

    private PaymentMethod payment_method;

    private PaymentStatus payment_status;
    private Timestamp payment_date;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonBackReference
    private Accounts account;

    @ManyToOne
    @JoinColumn(name = "ticket_id", insertable = false, updatable = false)
    @JsonBackReference
    private Tickets ticket;

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }

    public PaymentStatus getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(PaymentStatus payment_status) {
        this.payment_status = payment_status;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public Timestamp getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Timestamp payment_date) {
        this.payment_date = payment_date;
    }
}
