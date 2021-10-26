package com.podufalyy.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Flight {
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

    public Flight(Timestamp departureTime,
                  Timestamp arrivalTime,
                  Float allowedLuggage,
                  Integer connectedFlight,
                  Integer airlineId,
                  Integer departureAirportId,
                  Integer arrivalAirportId,
                  Integer departureAirportCountryId,
                  Integer arrivalAirportCountryId,
                  Integer planeId,
                  Integer flightClassId) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.allowedLuggage = allowedLuggage;
        this.connectedFlight = connectedFlight;
        this.airlineId = airlineId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureAirportCountryId = departureAirportCountryId;
        this.arrivalAirportCountryId = arrivalAirportCountryId;
        this.planeId = planeId;
        this.flightClassId = flightClassId;
    }

    @Override
    public String toString() {
        return "\n\nFlight{" +
                "departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", allowedLuggage=" + allowedLuggage +
                ", connectedFlight=" + connectedFlight +
                ", airlineId=" + airlineId +
                ", departureAirportId=" + departureAirportId +
                ", arrivalAirportId=" + arrivalAirportId +
                ", departureAirportCountryId=" + departureAirportCountryId +
                ", arrivalAirportCountryId=" + arrivalAirportCountryId +
                ", planeId=" + planeId +
                ", flightClassId=" + flightClassId;
    }
}
