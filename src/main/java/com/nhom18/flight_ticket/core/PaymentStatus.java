package com.nhom18.flight_ticket.core;

public enum PaymentStatus {
    PENDING("pending"),
    COMPLETED("completed"),
    FAILED("failed");

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PaymentStatus fromString(String value) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.value.equalsIgnoreCase(value)) {
                return paymentStatus;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
