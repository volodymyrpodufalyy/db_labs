package com.podufalyy.controller;

import com.podufalyy.domain.Airline;
import com.podufalyy.dto.AirlineDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.AirlineMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/airlines")
@RestController
@AllArgsConstructor
public class AirlineController extends AbstractController<Airline, AirlineDto, Integer> {
    private final AirlineService airlineService;
    private final AirlineMapper airlineMapper;


    @Override
    protected AbstractService<Airline, Integer> getService() {
        return airlineService;
    }

    @Override
    protected AbstractMapper<Airline, AirlineDto> getMapper() {
        return airlineMapper;
    }


    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<Airline> update(@PathVariable Integer id, @RequestBody Airline object) {
        if (getService().getById(id) != null) {
            airlineService.updateEntity(id, object);
            return new ResponseEntity<>(airlineService.updateEntity(id, object), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
