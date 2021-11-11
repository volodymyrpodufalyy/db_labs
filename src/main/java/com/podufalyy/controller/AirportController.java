package com.podufalyy.controller;

import com.podufalyy.domain.Airline;
import com.podufalyy.domain.Airport;
import com.podufalyy.dto.AirportDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.AirportMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/airports")
@RestController
@AllArgsConstructor
public class AirportController extends AbstractController<Airport, AirportDto, Integer> {
    private final AirportService airportService;
    private final AirportMapper airportMapper;


    @Override
    protected AbstractService<Airport, Integer> getService() {
        return airportService;
    }

    @Override
    protected AbstractMapper<Airport, AirportDto> getMapper() {
        return airportMapper;
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<Airport> update(@PathVariable Integer id, @RequestBody Airport object) {
        if (getService().getById(id) != null) {
            airportService.updateEntity(id, object);
            return new ResponseEntity<>(airportService.updateEntity(id, object), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}