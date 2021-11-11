package com.podufalyy.mapper;

import com.podufalyy.domain.FlightCLass;
import com.podufalyy.dto.FlightClassDto;
import org.springframework.stereotype.Component;

@Component
public class FlightClassMapper extends AbstractMapper<FlightCLass, FlightClassDto> {

    @Override
    public FlightClassDto mapObjectToDto(FlightCLass entity) {
        if (entity == null)
            return null;

        FlightClassDto.FlightClassDtoBuilder flightClassDto = FlightClassDto.builder();
        flightClassDto.id(entity.getId());
        flightClassDto.type(entity.getType());
        flightClassDto.benefits(entity.getBenefits());
        flightClassDto.price(entity.getPrice());

        return flightClassDto.build();
    }
}