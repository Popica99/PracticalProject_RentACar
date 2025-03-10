package org.example.Entities;

import org.example.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public void save(T obj)
    {
        Session session = sessionFactory.openSession();
        session.persist(obj);
        session.beginTransaction().commit();
        session.close();
    }

    public List<T> getList(Session session, String tableName)
    {
        List<T> list = new ArrayList<>();
        list = session.createQuery("From " + tableName).list();
        return list;
    }
}
