package com.podufalyy.dao;

import com.podufalyy.HibernateUtil;
import com.podufalyy.entities.UserHasFlight;
import com.podufalyy.entities.UserHasFlightPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHasFlightDAO implements DAOInterface<UserHasFlight>{
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public List<UserHasFlight> findAll() throws SQLException {
        List<UserHasFlight> flights = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            flights = session.createQuery("from UserHasFlight ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public void create(UserHasFlight entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserHasFlight findById(Integer id) throws SQLException {
        UserHasFlight userHasFlight = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            userHasFlight = session.get(UserHasFlight.class, 9);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userHasFlight;
    }

    @Override
    public void update(String name, UserHasFlight entity) throws SQLException {
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
            UserHasFlight entity = session.get(UserHasFlight.class, id);
            if (entity != null) {
                session.delete(entity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
