package com.nhom18.flight_ticket.dto.request;

import com.nhom18.flight_ticket.core.FlightStatus;

public class FlightUpdateRequest {
    private FlightStatus status;

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

}
