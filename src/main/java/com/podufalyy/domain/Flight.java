package com.podufalyy.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "departure_time")
    private Timestamp departureTime;

    @Basic
    @Column(name = "arrival_time")
    private Timestamp arrivalTime;

    @Basic
    @Column(name = "allowed_luggage_kg")
    private Float allowedLuggage;

    @Basic
    @Column(name = "connected_flight")
    private Integer connectedFlight;

    @Basic
    @Column(name = "airline_id")
    private Integer airlineId;

    @Basic
    @Column(name = "airport_id")
    private Integer departureAirportId;

    @Basic
    @Column(name = "airport_id1")
    private Integer arrivalAirportId;

    @Basic
    @Column(name = "airport_country_id")
    private Integer departureAirportCountryId;

    @Basic
    @Column(name = "airport_country_id1")
    private Integer arrivalAirportCountryId;

    @Basic
    @Column(name = "plane_id")
    private Integer planeId;


    @Basic
    @Column(name = "class_id")
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
