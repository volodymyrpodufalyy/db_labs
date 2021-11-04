package com.podufalyy.dao;

import com.podufalyy.HibernateUtil;
import com.podufalyy.entities.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class CityDAO implements DAOInterface<City> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            cities = session.createQuery("from City ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void create(City entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity.getName(), entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public City findByName(String name) throws SQLException {
        City city = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            city = session.get(City.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }


    @Override
    public void update(Integer id, City entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer name) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            City city = session.get(City.class, name);
            if (city != null) {
                session.delete(city);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
