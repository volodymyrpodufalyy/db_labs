package com.podufalyy.mapper;

import com.podufalyy.domain.Flight;
import com.podufalyy.dto.FlightDto;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper extends AbstractMapper<Flight, FlightDto> {

    @Override
    public FlightDto mapObjectToDto(Flight entity) {
        if (entity == null)
            return null;

        FlightDto.FlightDtoBuilder flightDto = FlightDto.builder();
        flightDto.id(entity.getId());
        flightDto.departureTime(entity.getDepartureTime());
        flightDto.arrivalTime(entity.getArrivalTime());
        flightDto.allowedLuggage(entity.getAllowedLuggage());
        flightDto.connectedFlight(entity.getConnectedFlight());
        flightDto.airlineId(entity.getAirlineId());
        flightDto.departureAirportId(entity.getDepartureAirportId());
        flightDto.arrivalAirportId(entity.getArrivalAirportId());
        flightDto.departureAirportCountryId(entity.getDepartureAirportCountryId());
        flightDto.arrivalAirportCountryId(entity.getArrivalAirportCountryId());
        flightDto.planeId(entity.getPlaneId());
        flightDto.flightClassId(entity.getFlightClassId());

        return flightDto.build();
    }
}