package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Plane;
import com.podufalyy.enums.PlaneType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO implements DAOInterface<Plane> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.plane";
    private static final String GET_BY_NAME = "SELECT * FROM podufalyy.plane WHERE name=?";
    private static final String CREATE = "INSERT podufalyy.plane "
            + "(`name`, `country_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.plane"
            + " SET country_id=? WHERE name=?";
    private static final String DELETE = "DELETE FROM podufalyy.plane WHERE name=?";


    @Override
    public List<Plane> findAll() throws SQLException {
        List<Plane> planes = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Plane plane = new Plane(
                        resultSet.getString("name"),
                        resultSet.getInt("seats"),
                        PlaneType.valueOf(resultSet.getString("type")),
                        resultSet.getInt("airline_id")
                );
                planes.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planes;
    }

    @Override
    public void create(Plane airline) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(airline.getName()));
            statement.setInt(2, airline.getSeats());
            statement.setString(3, String.valueOf(airline.getType()));
            statement.setInt(4, airline.getAirlineId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plane findByName(String name) throws SQLException {
        Plane plane = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                plane = new Plane(
                        resultSet.getString("name"),
                        resultSet.getInt("seats"),
                        PlaneType.valueOf(resultSet.getString("type")),
                        resultSet.getInt("airline_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plane;
    }

    @Override
    public void update(String name, Plane plane) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, plane.getName());
            statement.setInt(2, plane.getSeats());
            statement.setString(3,  String.valueOf(plane.getType()));
            statement.setInt(4, plane.getAirlineId());
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
