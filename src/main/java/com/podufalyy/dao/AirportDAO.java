package com.podufalyy.dao;

import com.podufalyy.db.HibernateManager;
import com.podufalyy.entities.Airport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked"})
public class AirportDAO implements DAOInterface<Airport> {
    protected final SessionFactory sessionFactory = HibernateManager.getSessionFactory();

    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            airports = session.createQuery("from Airport ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airports;
    }

    @Override
    public void create(Airport entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airport findById(Integer id) throws SQLException {
        Airport airport = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            airport = session.get(Airport.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airport;
    }

    @Override
    public void update(Integer id, Airport entity) throws SQLException {
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
            Airport airport = session.get(Airport.class, id);
            if (airport != null) {
                session.delete(airport);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
