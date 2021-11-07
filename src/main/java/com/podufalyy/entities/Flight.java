package com.podufalyy.entities;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Entity
public class Flight {
    private int id;
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

    public Flight() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "departure_time")
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "arrival_time")
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "allowed_luggage_kg")
    public Float getAllowedLuggage() {
        return allowedLuggage;
    }

    public void setAllowedLuggage(Float allowedLuggage) {
        this.allowedLuggage = allowedLuggage;
    }

    @Basic
    @Column(name = "connected_flight")
    public Integer getConnectedFlight() {
        return connectedFlight;
    }

    public void setConnectedFlight(Integer connectedFlight) {
        this.connectedFlight = connectedFlight;
    }

    @Basic
    @Column(name = "airline_id")
    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    @Basic
    @Column(name = "airport_id")
    public Integer getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Integer departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    @Basic
    @Column(name = "airport_id1")
    public Integer getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(Integer arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    @Basic
    @Column(name = "airport_country_id")
    public Integer getDepartureAirportCountryId() {
        return departureAirportCountryId;
    }

    public void setDepartureAirportCountryId(Integer departureAirportCountryId) {
        this.departureAirportCountryId = departureAirportCountryId;
    }

    @Basic
    @Column(name = "airport_country_id1")
    public Integer getArrivalAirportCountryId() {
        return arrivalAirportCountryId;
    }

    public void setArrivalAirportCountryId(Integer arrivalAirportCountryId) {
        this.arrivalAirportCountryId = arrivalAirportCountryId;
    }

    @Basic
    @Column(name = "plane_id")
    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    @Basic
    @Column(name = "class_id")
    public Integer getFlightClassId() {
        return flightClassId;
    }

    public void setFlightClassId(Integer flightClassId) {
        this.flightClassId = flightClassId;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() && Objects.equals(getDepartureTime(), flight.getDepartureTime()) && Objects.equals(getArrivalTime(), flight.getArrivalTime()) && Objects.equals(getAllowedLuggage(), flight.getAllowedLuggage()) && Objects.equals(getConnectedFlight(), flight.getConnectedFlight()) && Objects.equals(getAirlineId(), flight.getAirlineId()) && Objects.equals(getDepartureAirportId(), flight.getDepartureAirportId()) && Objects.equals(getArrivalAirportId(), flight.getArrivalAirportId()) && Objects.equals(getDepartureAirportCountryId(), flight.getDepartureAirportCountryId()) && Objects.equals(getArrivalAirportCountryId(), flight.getArrivalAirportCountryId()) && Objects.equals(getPlaneId(), flight.getPlaneId()) && Objects.equals(getFlightClassId(), flight.getFlightClassId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartureTime(), getArrivalTime(), getAllowedLuggage(), getConnectedFlight(), getAirlineId(), getDepartureAirportId(), getArrivalAirportId(), getDepartureAirportCountryId(), getArrivalAirportCountryId(), getPlaneId(), getFlightClassId());
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
