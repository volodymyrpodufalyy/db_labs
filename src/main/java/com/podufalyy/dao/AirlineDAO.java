package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.db.HibernateManager;
import com.podufalyy.entities.Airline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked"})
public class AirlineDAO implements DAOInterface<Airline> {
    protected final SessionFactory sessionFactory = HibernateManager.getSessionFactory();


    @Override
    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            airlines = session.createQuery("from Airline ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airlines;
    }

    @Override
    public void create(Airline entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airline findById(Integer id) throws SQLException {
        Airline airline = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            airline = session.get(Airline.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airline;
    }

    @Override
    public void update(Integer id, Airline entity) throws SQLException {
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
            Airline airline = session.get(Airline.class, id);
            if (airline != null) {
                session.delete(airline);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
