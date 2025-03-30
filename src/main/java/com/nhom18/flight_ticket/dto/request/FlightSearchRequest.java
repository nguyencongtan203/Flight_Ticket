package com.nhom18.flight_ticket.dto.request;

public class FlightSearchRequest {
    private String departureId;  // Mã sân bay đi (VD: SGN)
    private String arrivalId;  // Mã sân bay đến (VD: HAN)
    private String outboundDate;  // Ngày đi (VD: 2025-03-30)
    private String returnDate;  // Ngày về (nếu có)

    // Getters & Setters
    public String getDepartureId() {
        return departureId;
    }

    public void setDepartureId(String departureId) {
        this.departureId = departureId;
    }

    public String getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(String arrivalId) {
        this.arrivalId = arrivalId;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
