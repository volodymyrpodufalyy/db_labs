package com.podufalyy.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(UserHasFlightPK.class)
public class UserHasFlight {
    private Integer userId;
    private Integer flightId;
    private Integer flightArrivalAirportId;
    private Integer flightArrivalAirportCountryId;
    private Integer flightDepartureAirportId;
    private Integer flightDepartureAirportCountryId;
    private Integer flightPlaneId;

    @Id
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "flight_id")
    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "flight_airport_id")
    public Integer getFlightArrivalAirportId() {
        return flightArrivalAirportId;
    }

    public void setFlightArrivalAirportId(Integer flightArrivalAirportId) {
        this.flightArrivalAirportId = flightArrivalAirportId;
    }

    @Basic
    @Column(name = "flight_airport_country_id")
    public Integer getFlightArrivalAirportCountryId() {
        return flightArrivalAirportCountryId;
    }

    public void setFlightArrivalAirportCountryId(Integer flightArrivalAirportCountryId) {
        this.flightArrivalAirportCountryId = flightArrivalAirportCountryId;
    }

    @Basic
    @Column(name = "flight_airport_id1")
    public Integer getFlightDepartureAirportId() {
        return flightDepartureAirportId;
    }

    public void setFlightDepartureAirportId(Integer flightDepartureAirportId) {
        this.flightDepartureAirportId = flightDepartureAirportId;
    }

    @Basic
    @Column(name = "flight_airport_country_id1")
    public Integer getFlightDepartureAirportCountryId() {
        return flightDepartureAirportCountryId;
    }

    public void setFlightDepartureAirportCountryId(Integer flightDepartureAirportCountryId) {
        this.flightDepartureAirportCountryId = flightDepartureAirportCountryId;
    }

    @Basic
    @Column(name = "flight_plane_id")
    public Integer getFlightPlaneId() {
        return flightPlaneId;
    }

    public void setFlightPlaneId(Integer flightPlaneId) {
        this.flightPlaneId = flightPlaneId;
    }

    public UserHasFlight() {
    }

    public UserHasFlight(Integer userId, Integer flightId,
                         Integer flightArrivalAirportId,
                         Integer flightArrivalAirportCountryId,
                         Integer flightDepartureAirportId,
                         Integer flightDepartureAirportCountryId,
                         Integer flightPlaneId) {
        this.userId = userId;
        this.flightId = flightId;
        this.flightArrivalAirportId = flightArrivalAirportId;
        this.flightArrivalAirportCountryId = flightArrivalAirportCountryId;
        this.flightDepartureAirportId = flightDepartureAirportId;
        this.flightDepartureAirportCountryId = flightDepartureAirportCountryId;
        this.flightPlaneId = flightPlaneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserHasFlight)) return false;
        UserHasFlight that = (UserHasFlight) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getFlightId(), that.getFlightId()) && Objects.equals(getFlightArrivalAirportId(), that.getFlightArrivalAirportId()) && Objects.equals(getFlightArrivalAirportCountryId(), that.getFlightArrivalAirportCountryId()) && Objects.equals(getFlightDepartureAirportId(), that.getFlightDepartureAirportId()) && Objects.equals(getFlightDepartureAirportCountryId(), that.getFlightDepartureAirportCountryId()) && Objects.equals(getFlightPlaneId(), that.getFlightPlaneId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFlightId(), getFlightArrivalAirportId(), getFlightArrivalAirportCountryId(), getFlightDepartureAirportId(), getFlightDepartureAirportCountryId(), getFlightPlaneId());
    }

    @Override
    public String toString() {
        return "\n\nUserHasFlight{" +
                "userId=" + userId +
                ", flightId=" + flightId +
                ", flightArrivalAirportId=" + flightArrivalAirportId +
                ", flightArrivalAirportCountryId=" + flightArrivalAirportCountryId +
                ", flightDepartureAirportId=" + flightDepartureAirportId +
                ", flightDepartureAirportCountryId=" + flightDepartureAirportCountryId +
                ", flightPlaneId=" + flightPlaneId;
    }
}
