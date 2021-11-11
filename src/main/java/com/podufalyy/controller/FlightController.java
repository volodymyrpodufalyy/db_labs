package com.podufalyy.controller;

import com.podufalyy.domain.Flight;
import com.podufalyy.dto.FlightDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.FlightMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/flights")
@RestController
@AllArgsConstructor
public class FlightController extends AbstractController<Flight, FlightDto, Integer> {
    private final FlightService flightService;
    private final FlightMapper flightMapper;


    @Override
    protected AbstractService<Flight, Integer> getService() {
        return flightService;
    }

    @Override
    protected AbstractMapper<Flight, FlightDto> getMapper() {
        return flightMapper;
    }
}
