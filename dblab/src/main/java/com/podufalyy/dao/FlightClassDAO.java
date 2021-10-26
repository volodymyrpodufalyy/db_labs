package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.FlightCLass;
import com.podufalyy.enums.ClassType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightClassDAO implements DAOInterface<FlightCLass> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.class";
    private static final String GET_BY_NAME = "SELECT * FROM podufalyy.class WHERE type=?";
    private static final String CREATE = "INSERT podufalyy.class "
            + "(`type`, `benefits`, `price`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.class"
            + " SET benefits=? WHERE type=?";
    private static final String DELETE = "DELETE FROM podufalyy.class WHERE type=?";


    @Override
    public List<FlightCLass> findAll() throws SQLException {
        List<FlightCLass> flightClasses = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FlightCLass flightClass = new FlightCLass(
                        ClassType.valueOf(resultSet.getString("type")),
                        resultSet.getString("benefits"),
                        resultSet.getFloat("price")
                );
                flightClasses.add(flightClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightClasses;
    }

    @Override
    public void create(FlightCLass flightClass) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(flightClass.getType()));
            statement.setString(2, flightClass.getBenefits());
            statement.setFloat(3, flightClass.getPrice());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public FlightCLass findByName(String name) throws SQLException {
        FlightCLass flightCLass = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flightCLass = new FlightCLass(
                        ClassType.valueOf(resultSet.getString("type")),
                        resultSet.getString("benefits"),
                        resultSet.getFloat("price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightCLass;
    }

    @Override
    public void update(String name, FlightCLass flightClass) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, String.valueOf(flightClass.getType()));
            statement.setString(2, flightClass.getBenefits());
            statement.setFloat(3, flightClass.getPrice());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String type) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, type);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
