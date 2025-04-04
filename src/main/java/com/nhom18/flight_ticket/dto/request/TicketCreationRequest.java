package com.nhom18.flight_ticket.dto.request;

import com.nhom18.flight_ticket.core.TicketStatus;

import java.math.BigDecimal;

public class TicketCreationRequest {
    private int book_by_account_id;
    private int flight_id;
    private int seat_id;
    private int class_id;
    private String phone_number;
    private String name;
    private BigDecimal price;

    public int getBook_by_account_id() {
        return book_by_account_id;
    }

    public void setBook_by_account_id(int book_by_account_id) {
        this.book_by_account_id = book_by_account_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
