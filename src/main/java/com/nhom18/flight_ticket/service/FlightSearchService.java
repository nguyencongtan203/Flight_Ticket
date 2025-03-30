package com.nhom18.flight_ticket.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhom18.flight_ticket.dto.response.FlightSearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightSearchService {
    private static final String SERPAPI_KEY = "0af9d871d47dd3c85ab8a5f44b4bd1f539ca1180962168a5150eef13465fa050";
    private static final String SERPAPI_URL = "https://serpapi.com/search.json";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public FlightSearchService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<FlightSearchResponse> searchFlights(String departureId, String arrivalId, String outboundDate,
            String returnDate) {
        List<FlightSearchResponse> results = new ArrayList<>();

        try {
            // Xác định loại chuyến bay
            String type = (returnDate != null && !returnDate.isEmpty()) ? "1" : "2";

            // ✅ Tạo URL với type chính xác
            String apiUrl = SERPAPI_URL + "?engine=google_flights"
                    + "&departure_id=" + departureId
                    + "&arrival_id=" + arrivalId
                    + "&outbound_date=" + outboundDate
                    + (returnDate != null && !returnDate.isEmpty() ? "&return_date=" + returnDate : "")
                    + "&type=" + type
                    + "&api_key=" + SERPAPI_KEY;

            // ✅ Gửi request đến SerpAPI
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            String jsonResponse = response.getBody();

            // 🟢 In JSON gốc để kiểm tra phản hồi API
            System.out.println("JSON Response: " + jsonResponse);

            // ✅ Xử lý JSON response
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode bestFlightsNode = rootNode.path("best_flights");

            for (JsonNode bestFlight : bestFlightsNode) {
                JsonNode flightsArray = bestFlight.path("flights"); // Lấy danh sách flights

                for (JsonNode flight : flightsArray) {
                    FlightSearchResponse flightResponse = new FlightSearchResponse();

                    flightResponse.setAirlineLogo(flight.path("airline_logo").asText());

                    // Lấy thông tin sân bay đi
                    JsonNode departureNode = flight.path("departure_airport");
                    flightResponse.setDepartureAirportId(departureNode.path("id").asText());
                    flightResponse.setDepartureTime(departureNode.path("time").asText());

                    // Lấy thông tin sân bay đến
                    JsonNode arrivalNode = flight.path("arrival_airport");
                    flightResponse.setArrivalAirportId(arrivalNode.path("id").asText());
                    flightResponse.setArrivalTime(arrivalNode.path("time").asText());

                    // Thời gian bay
                    flightResponse.setDuration(flight.path("duration").asInt());
                    // Hạng ghế
                    flightResponse.setTravelClass(flight.path("travel_class").asText());

                    results.add(flightResponse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

}
