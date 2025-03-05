package org.example.Entities;

import org.example.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAO {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public void insertCar(Car car)
    {
        Session session = sessionFactory.openSession();
        session.persist(car);
        session.beginTransaction().commit();
        session.close();
    }

    public void insertClient(Client client)
    {
        Session session = sessionFactory.openSession();
        session.persist(client);
        session.beginTransaction().commit();
        session.close();
    }

    public void insertReview(Review review)
    {
        Session session = sessionFactory.openSession();
        session.persist(review);
        session.beginTransaction().commit();
        session.close();
    }

    public List<Car> displayCars(List<Car> cars)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        cars = session.createQuery("From Car", Car.class).list();

        transaction.commit();

        return cars;
    }

}
