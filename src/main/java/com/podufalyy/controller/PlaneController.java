package com.podufalyy.controller;

import com.podufalyy.domain.Plane;
import com.podufalyy.service.PlaneService;

import java.sql.SQLException;
import java.util.List;

public class PlaneController implements ControllerInterface<Plane> {
    PlaneService service = new PlaneService();

    @Override
    public List<Plane> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Plane entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Plane findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public Plane findById(Integer name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void update(Integer id, Plane entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
