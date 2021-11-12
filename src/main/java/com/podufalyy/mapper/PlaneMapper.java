package com.podufalyy.mapper;

import com.podufalyy.domain.Plane;
import com.podufalyy.dto.PlaneDto;
import org.springframework.stereotype.Component;

@Component
public class PlaneMapper extends AbstractMapper<Plane, PlaneDto> {

    @Override
    public PlaneDto mapObjectToDto(Plane entity) {
        if (entity == null)
            return null;

        PlaneDto.PlaneDtoBuilder planeDto = PlaneDto.builder();
        planeDto.id(entity.getId());
        planeDto.name(entity.getName());
        planeDto.seats(entity.getSeats());
        planeDto.type(entity.getType());
        planeDto.airlineId(entity.getAirlineId());

        return planeDto.build();
    }
}
