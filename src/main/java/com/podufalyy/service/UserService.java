package com.podufalyy.service;

import com.podufalyy.dao.UserDAO;
import com.podufalyy.entities.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements ServiceInterface<User> {
    private final UserDAO dao = new UserDAO();

    @Override
    public List<User> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(User entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, User entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
