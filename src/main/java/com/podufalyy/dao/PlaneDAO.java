package com.podufalyy.dao;


import com.podufalyy.db.HibernateManager;

import com.podufalyy.entities.Plane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked"})
public class PlaneDAO implements DAOInterface<Plane> {
    protected final SessionFactory sessionFactory = HibernateManager.getSessionFactory();


    @Override
    public List<Plane> findAll() throws SQLException {
        List<Plane> planes = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            planes = session.createQuery("from Plane ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planes;
    }

    @Override
    public void create(Plane entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plane findById(Integer id) throws SQLException {
        Plane plane = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            plane = session.get(Plane.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plane;
    }

    @Override
    public void update(Integer name, Plane entity) throws SQLException {
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
            Plane plane = session.get(Plane.class, id);
            if (plane != null) {
                session.delete(plane);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
