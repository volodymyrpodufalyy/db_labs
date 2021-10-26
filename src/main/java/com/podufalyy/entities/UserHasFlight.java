package com.podufalyy.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHasFlight {
    private Integer userId;
    private Integer flightId;
    private Integer flightArrivalAirportId;
    private Integer flightArrivalAirportCountryId;
    private Integer flightDepartureAirportId;
    private Integer flightDepartureAirportCountryId;
    private Integer flightPlaneId;

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
