package com.podufalyy.controller;

import com.podufalyy.domain.Airport;
import com.podufalyy.domain.City;
import com.podufalyy.dto.CityDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.CityMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/cities")
@RestController
@AllArgsConstructor
public class CityController extends AbstractController<City, CityDto,Integer> {
    private final CityService cityService;
    private final CityMapper cityMapper;


    @Override
    protected AbstractService<City, Integer> getService() {
        return cityService;
    }

    @Override
    protected AbstractMapper<City, CityDto> getMapper() {
        return cityMapper;
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<City> update(@PathVariable Integer id, @RequestBody City object) {
        if (getService().getById(id) != null) {
            cityService.updateEntity(id, object);
            return new ResponseEntity<>(cityService.updateEntity(id, object), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}