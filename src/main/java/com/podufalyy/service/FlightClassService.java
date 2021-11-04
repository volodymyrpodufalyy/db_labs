package com.podufalyy.service;

import com.podufalyy.dao.FlightClassDAO;
import com.podufalyy.entities.FlightCLass;

import java.sql.SQLException;
import java.util.List;

public class FlightClassService implements ServiceInterface<FlightCLass> {
    private final FlightClassDAO dao = new FlightClassDAO();

    @Override
    public List<FlightCLass> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public FlightCLass findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public FlightCLass findById(Integer name) throws SQLException {
        return dao.findById(name);
    }


    @Override
    public void create(FlightCLass entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, FlightCLass entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
