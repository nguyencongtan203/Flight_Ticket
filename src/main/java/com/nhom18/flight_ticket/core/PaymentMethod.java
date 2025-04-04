package com.nhom18.flight_ticket.core;

public enum PaymentMethod {
    CREDIT_CARD("credit_card"),
    PAYPAL("paypal"),
    BANK_TRANSFER("bank_transfer");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PaymentMethod fromString(String value) {
        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            if (paymentMethod.value.equalsIgnoreCase(value)) {
                return paymentMethod;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
