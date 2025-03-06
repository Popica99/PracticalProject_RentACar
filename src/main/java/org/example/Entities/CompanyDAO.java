package org.example.Entities;

import org.example.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
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

    public void insertReview(Review review, String clientName)
    {
        Session session = sessionFactory.openSession();

        Client client = new Client();
        client = (Client) session.createQuery("Select c From Client c WHERE c.client_Name =: clientName").setParameter("clientName", clientName).getSingleResult();

        review.setClient(client);

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

    public List<Client> displayClients(List<Client> clients)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        clients = session.createQuery("From Client", Client.class).list();

        transaction.commit();

        return clients;
    }

    public List<Review> displayReviews(List<Review> reviews)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        reviews = session.createQuery("From Review", Review.class).list();

        transaction.commit();

        return reviews;
    }

    public void insertRent(Rent rent, String clientName,String carModel)
    {
        Session session = sessionFactory.openSession();

        Client client = new Client();
        client = (Client) session.createQuery("Select c From Client c Where c.client_Name =: clientName").setParameter("clientName", clientName).getSingleResult();
        rent.setClient(client);



        Car car = new Car();
        car = (Car) session.createQuery("Select c From Car c Where c.car_Model =: carModel").setParameter("carModel", carModel).getSingleResult();
        rent.setCar(car);

        List<Rent> rents = new ArrayList<>();
        rents = session.createQuery("From Rent", Rent.class).list();
        for (Rent rent1 : rents)
        {
            if (rent1.getCar().getCar_Id() == rent.getCar().getCar_Id())
            {
                if (rent1.getEnd_Period().isBefore(rent.getStart_Period())) session.persist(rent);
                else System.out.println("Unavailable car from this date!");
            }
        }


        session.beginTransaction().commit();
        session.close();
    }

}
