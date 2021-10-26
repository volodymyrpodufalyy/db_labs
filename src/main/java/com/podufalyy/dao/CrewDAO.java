package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Crew;
import com.podufalyy.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrewDAO implements DAOInterface<Crew> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.crew";
    private static final String GET_BY_NAME = "SELECT * FROM podufalyy.crew WHERE main_pilot=?";
    private static final String CREATE = "INSERT podufalyy.crew "
            + "(`main_pilot`, `stewardess`, `second_pilot`, `plane_id`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.crew"
            + " SET stewardess=? WHERE main_pilot=?";
    private static final String DELETE = "DELETE FROM podufalyy.crew WHERE main_pilot=?";


    @Override
    public List<Crew> findAll() throws SQLException {
        List<Crew> users = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crew crew = new Crew(
                        resultSet.getString("main_pilot"),
                        resultSet.getString("stewardess"),
                        resultSet.getString("second_pilot"),
                        resultSet.getInt("plane_id")
                );
                users.add(crew);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void create(Crew crew) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, crew.getMainPilot());
            statement.setString(2, crew.getStewardess());
            statement.setString(3, crew.getSecondPilot());
            statement.setString(4, crew.getMainPilot());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Crew findByName(String name) throws SQLException {
        Crew crew = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                crew = new Crew(
                        resultSet.getString("main_pilot"),
                        resultSet.getString("stewardess"),
                        resultSet.getString("second_pilot"),
                        resultSet.getInt("plane_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crew;
    }

    @Override
    public void update(String name, Crew crew) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, crew.getMainPilot());
            statement.setString(2, crew.getStewardess());
            statement.setString(3, crew.getSecondPilot());
            statement.setString(4, crew.getMainPilot());
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
