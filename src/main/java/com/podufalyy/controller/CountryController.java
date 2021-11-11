package com.podufalyy.controller;

import com.podufalyy.domain.Country;
import com.podufalyy.dto.CountryDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.CountryMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/countries")
@RestController
@AllArgsConstructor
public class CountryController extends AbstractController<Country, CountryDto, Integer> {
    private final CountryService countryService;
    private final CountryMapper countryMapper;


    @Override
    protected AbstractService<Country, Integer> getService() {
        return countryService;
    }

    @Override
    protected AbstractMapper<Country, CountryDto> getMapper() {
        return countryMapper;
    }
}