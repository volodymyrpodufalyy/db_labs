package com.podufalyy.controller;

import com.podufalyy.domain.Flight;
import com.podufalyy.service.FlightService;

import java.sql.SQLException;
import java.util.List;

public class FlightController implements ControllerInterface<Flight> {
    FlightService service = new FlightService();

    @Override
    public List<Flight> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Flight entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Flight findByName(String name) throws SQLException {
        return service.findByName(name);
    }


    @Override
    public Flight findById(Integer name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void update(String name, Flight entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
