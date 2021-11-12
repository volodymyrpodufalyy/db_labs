package com.podufalyy.controller;

import com.podufalyy.domain.Plane;
import com.podufalyy.dto.PlaneDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.PlaneMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/planes")
@RestController
@AllArgsConstructor
public class PlaneController extends AbstractController<Plane, PlaneDto, Integer> {
    private final PlaneService planeService;
    private final PlaneMapper planeMapper;


    @Override
    protected AbstractService<Plane, Integer> getService() {
        return planeService;
    }

    @Override
    protected AbstractMapper<Plane, PlaneDto> getMapper() {
        return planeMapper;
    }
}
