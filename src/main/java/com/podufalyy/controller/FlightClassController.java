package com.podufalyy.controller;

import com.podufalyy.entities.FlightCLass;
import com.podufalyy.service.FlightClassService;

import java.sql.SQLException;
import java.util.List;

public class FlightClassController implements ControllerInterface<FlightCLass> {
    FlightClassService service = new FlightClassService();

    @Override
    public List<FlightCLass> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(FlightCLass entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public FlightCLass findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public FlightCLass findById(Integer name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void update(String name, FlightCLass entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
