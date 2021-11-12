package com.podufalyy.mapper;

import com.podufalyy.domain.Airline;
import com.podufalyy.dto.AirlineDto;
import com.podufalyy.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public class AirlineMapper extends AbstractMapper<Airline, AirlineDto> {

    @Override
    public AirlineDto mapObjectToDto(Airline entity) {
        if (entity == null)
            return null;

        AirlineDto.AirlineDtoBuilder airlineDto = AirlineDto.builder();
        airlineDto.id(entity.getId());
        airlineDto.name(entity.getName());
        airlineDto.countryId(entity.getCountryId());

        return airlineDto.build();
    }


}
