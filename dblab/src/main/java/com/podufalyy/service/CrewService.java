package com.podufalyy.service;

import com.podufalyy.dao.CrewDAO;
import com.podufalyy.entities.Crew;

import java.sql.SQLException;
import java.util.List;

public class CrewService implements ServiceInterface<Crew> {
    private final CrewDAO dao = new CrewDAO();

    @Override
    public List<Crew> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Crew findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(Crew entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, Crew entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
