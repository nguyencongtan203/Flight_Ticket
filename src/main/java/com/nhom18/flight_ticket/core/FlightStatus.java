package com.nhom18.flight_ticket.core;

public enum FlightStatus {
    SCHEDULED("scheduled"),
    DELAYED("delayed"),
    CANCELLED("cancelled"),
    COMPLETED("completed"),
    FULLY_BOOKED("fully_booked");

    private final String value;

    FlightStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FlightStatus fromString(String value) {
        for (FlightStatus flightStatus : FlightStatus.values()) {
            if (flightStatus.value.equalsIgnoreCase(value)) {
                return flightStatus;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
