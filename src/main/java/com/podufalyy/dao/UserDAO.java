package com.podufalyy.dao;

import com.podufalyy.HibernateUtil;
import com.podufalyy.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAOInterface<User> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            users = session.createQuery("from User ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void create(User entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity.getFirstName(), entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(String name, User entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User entity = session.get(User.class, name);
            if (entity != null) {
                session.delete(entity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
