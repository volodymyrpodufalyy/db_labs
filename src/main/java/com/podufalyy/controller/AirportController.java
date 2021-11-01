package com.podufalyy.controller;

import com.podufalyy.entities.Airport;
import com.podufalyy.service.AirportService;

import java.sql.SQLException;
import java.util.List;

public class AirportController implements ControllerInterface<Airport> {
    AirportService service = new AirportService();

    @Override
    public List<Airport> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Airport entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Airport findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public Airport findById(Integer name) throws SQLException {
        return service.findById(name);
    }


    @Override
    public void update(String name, Airport entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
