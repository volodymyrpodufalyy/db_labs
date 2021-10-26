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
    public void create(Airport entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, Airport entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
