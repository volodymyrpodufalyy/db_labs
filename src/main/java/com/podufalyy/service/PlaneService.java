package com.podufalyy.service;

import com.podufalyy.dao.CountryDAO;
import com.podufalyy.dao.PlaneDAO;
import com.podufalyy.entities.Country;
import com.podufalyy.entities.Plane;

import java.sql.SQLException;
import java.util.List;

public class PlaneService implements ServiceInterface<Plane> {
    private final PlaneDAO dao = new PlaneDAO();

    @Override
    public List<Plane> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Plane findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public Plane findById(Integer name) throws SQLException {
        return dao.findById(name);
    }

    @Override
    public void create(Plane entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Plane entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
