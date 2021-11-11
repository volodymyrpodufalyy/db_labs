package com.podufalyy.mapper;

import com.podufalyy.domain.Country;
import com.podufalyy.dto.CountryDto;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper extends AbstractMapper<Country, CountryDto> {

    @Override
    public CountryDto mapObjectToDto(Country country) {
        if (country == null)
            return null;

        CountryDto.CountryDtoBuilder countryDto = CountryDto.builder();
        countryDto.id(country.getId());
        countryDto.name(country.getName());
        countryDto.covidRules(country.getCovidRules());

        return countryDto.build();
    }
}