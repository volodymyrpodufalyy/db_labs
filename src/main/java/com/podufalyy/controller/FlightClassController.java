package com.podufalyy.controller;

import com.podufalyy.domain.FlightCLass;
import com.podufalyy.dto.FlightClassDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.FlightClassMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.FlightClassService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/flightclasses")
@RestController
@AllArgsConstructor
public class FlightClassController extends AbstractController<FlightCLass, FlightClassDto, Integer> {
    private final FlightClassService flightClassService;
    private final FlightClassMapper flightClassMapper;


    @Override
    protected AbstractService<FlightCLass, Integer> getService() {
        return flightClassService;
    }

    @Override
    protected AbstractMapper<FlightCLass, FlightClassDto> getMapper() {
        return flightClassMapper;
    }
}
