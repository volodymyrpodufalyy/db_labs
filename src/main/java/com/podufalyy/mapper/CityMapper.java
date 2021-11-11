package com.podufalyy.mapper;

import com.podufalyy.domain.City;
import com.podufalyy.dto.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper extends AbstractMapper<City, CityDto> {

    @Override
    public CityDto mapObjectToDto(City city) {
        if (city == null)
            return null;

        CityDto.CityDtoBuilder cityDto = CityDto.builder();
        cityDto.id(city.getId());
        cityDto.name(city.getName());
        cityDto.countryId(city.getCountryId());

        return cityDto.build();
    }
}
