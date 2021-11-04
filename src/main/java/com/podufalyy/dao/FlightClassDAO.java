package com.podufalyy.dao;

import com.podufalyy.HibernateUtil;
import com.podufalyy.entities.FlightCLass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class FlightClassDAO implements DAOInterface<FlightCLass> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();



    @Override
    public List<FlightCLass> findAll() throws SQLException {
        List<FlightCLass> flightClasses = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            flightClasses = session.createQuery("from FlightCLass ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightClasses;
    }

    @Override
    public void create(FlightCLass entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public FlightCLass findById(Integer id) throws SQLException {
        FlightCLass flightCLass = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            flightCLass = session.get(FlightCLass.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightCLass;
    }

    @Override
    public void update(String name, FlightCLass entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            FlightCLass flightclass = session.get(FlightCLass.class, id);
            if (flightclass != null) {
                session.delete(flightclass);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
