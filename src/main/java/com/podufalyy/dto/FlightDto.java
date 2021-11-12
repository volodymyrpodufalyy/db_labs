package com.podufalyy.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
    private Integer id;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private Float allowedLuggage;
    private Integer connectedFlight;
    private Integer airlineId;
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    private Integer departureAirportCountryId;
    private Integer arrivalAirportCountryId;
    private Integer planeId;
    private Integer flightClassId;
}
