package com.nhom18.flight_ticket.dto.request;

import com.nhom18.flight_ticket.core.TicketStatus;

public class TicketUpdateRequest {
    private TicketStatus status;

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
