package com.podufalyy.controller;

import com.podufalyy.domain.User;
import com.podufalyy.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController implements ControllerInterface<User> {
    UserService service = new UserService();

    @Override
    public List<User> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(User entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void update(String name, User entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
