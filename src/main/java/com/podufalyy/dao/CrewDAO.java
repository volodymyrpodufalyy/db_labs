package com.podufalyy.dao;

import com.podufalyy.HibernateUtil;
import com.podufalyy.entities.Crew;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class CrewDAO implements DAOInterface<Crew> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Crew> findAll() throws SQLException {
        List<Crew> crews = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            crews = session.createQuery("from Crew ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crews;
    }

    @Override
    public void create(Crew entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity.getMainPilot(), entity);
            session.save(entity.getSecondPilot(), entity);
            session.save(entity.getStewardess(), entity);;
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Crew findById(Integer id) throws SQLException {
        Crew crew = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            crew = session.get(Crew.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crew;
    }

    @Override
    public void update(String id, Crew entity) throws SQLException {
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
            Crew crew = session.get(Crew.class, id);
            if (crew != null) {
                session.delete(crew);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
