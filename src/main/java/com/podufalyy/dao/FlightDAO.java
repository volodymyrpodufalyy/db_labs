package com.podufalyy.dao;

import com.podufalyy.db.HibernateManager;
import com.podufalyy.entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class FlightDAO implements DAOInterface<Flight> {
    protected final SessionFactory sessionFactory = HibernateManager.getSessionFactory();

    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            flights = session.createQuery("from Flight ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public void create(Flight entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flight findById(Integer id) throws SQLException {
        Flight flight = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            flight = session.get(Flight.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flight;
    }


    @Override
    public void update(Integer name, Flight entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Flight flight = session.get(Flight.class, id);
            if (flight != null) {
                session.delete(flight);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
