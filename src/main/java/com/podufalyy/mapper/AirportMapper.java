package com.podufalyy.mapper;

import com.podufalyy.domain.Airport;
import com.podufalyy.dto.AirportDto;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper extends AbstractMapper<Airport, AirportDto> {
    @Override
    public AirportDto mapObjectToDto(Airport entity) {
        if (entity == null)
            return null;

        AirportDto.AirportDtoBuilder airportDto = AirportDto.builder();
        airportDto.id(entity.getId());
        airportDto.name(entity.getName());
        airportDto.countryId(entity.getCountryId());
        airportDto.cityId(entity.getCityId());

        return airportDto.build();
    }
}
