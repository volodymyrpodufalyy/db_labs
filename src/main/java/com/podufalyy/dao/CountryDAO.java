package com.podufalyy.dao;

import com.podufalyy.HibernateUtil;
import com.podufalyy.entities.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked"})
public class CountryDAO implements DAOInterface<Country> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            countries = session.createQuery("from Country ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void create(Country entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity.getName(), entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Country findByName(String name) throws SQLException {
        Country country = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            country = session.get(Country.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void update(Integer id, Country entity) throws SQLException {
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
            Country country = session.get(Country.class, id);
            if (country != null) {
                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
