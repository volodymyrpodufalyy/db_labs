package com.podufalyy.service;

import com.podufalyy.dao.AirportDAO;
import com.podufalyy.dao.CountryDAO;
import com.podufalyy.entities.Airport;
import com.podufalyy.entities.Country;

import java.sql.SQLException;
import java.util.List;

public class AirportService implements ServiceInterface<Airport> {
    private final AirportDAO dao = new AirportDAO();

    @Override
    public List<Airport> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Airport findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public Airport findById(Integer name) throws SQLException {
        return dao.findById(name);
    }

    @Override
    public void create(Airport entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Airport entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
