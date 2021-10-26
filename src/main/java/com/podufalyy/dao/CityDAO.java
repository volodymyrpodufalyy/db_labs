package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Airline;
import com.podufalyy.entities.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements DAOInterface<City> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.city";
    private static final String GET_BY_NAME = "SELECT * FROM podufalyy.city WHERE name=?";
    private static final String CREATE = "INSERT podufalyy.city "
            + "(`name`, `country_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.city"
            + " SET language=? WHERE name=? AND region_name=? AND region_country_name=?";
    private static final String DELETE = "DELETE FROM podufalyy.city WHERE name=?";

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                City city = new City(
                        resultSet.getString("name"),
                        resultSet.getInt("country_id")
                );
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void create(City city) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(city.getName()));
            statement.setInt(2, city.getCountryId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public City findByName(String name) throws SQLException {
        City city = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                city = new City(
                        resultSet.getString("name"),
                        resultSet.getInt("country_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }


    @Override
    public void update(String name, City city) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getCountryId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, name);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
