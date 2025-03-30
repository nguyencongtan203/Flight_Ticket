package com.nhom18.flight_ticket.core;

public enum TicketStatus {
    BOOKED("booked"),
    CHECKED_IN("checked-in"),
    CANCELLED("cancelled");
    private final String value;

    TicketStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TicketStatus fromString(String value) {
        for (TicketStatus ticketStatus : TicketStatus.values()) {
            if (ticketStatus.value.equalsIgnoreCase(value)) {
                return ticketStatus;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
