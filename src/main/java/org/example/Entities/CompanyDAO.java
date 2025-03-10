package org.example.Entities;

import jakarta.persistence.NoResultException;
import org.example.Exceptions.InvalidCarException;
import org.example.Exceptions.InvalidClientException;
import org.example.Exceptions.InvalidPeriodException;
import org.example.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
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

        List<Client> clients = new ArrayList<>();
        clients = session.createQuery("From Client", Client.class).list();

        boolean checkIfClientAlreadyExists = false;

        for (Client client1 : clients)
        {
            if (client1.getClient_Name().equalsIgnoreCase(client.getClient_Name()))
            {
                checkIfClientAlreadyExists = true;
            }
        }

        if (!checkIfClientAlreadyExists)
        {
            session.persist(client);
        }
        else
        {
            System.out.println("This client already registered!");
        }

        session.beginTransaction().commit();
        session.close();
    }

    public void insertReview(Review review, String clientName) throws InvalidClientException
    {
        boolean checkClientsInRents = false;
        Session session = sessionFactory.openSession();

        Client client = new Client();

        try
        {
            client = (Client) session.createQuery("Select c From Client c WHERE c.client_Name =: clientName").setParameter("clientName", clientName).getSingleResult();
        }
        catch (NoResultException e)
        {
            throw new InvalidClientException("Client name is not registered");
        }

        List<Rent> rents = new ArrayList<>();
        rents =  session.createQuery("From Rent", Rent.class).list();

        for (Rent rent : rents)
        {
            if (rent.getClient().getClient_Id() == client.getClient_Id())
            {
                checkClientsInRents = true;
            }
        }

        boolean checkIfClientAlreadyWroteAReview = false;
        List<Review> reviews = session.createQuery("From Review", Review.class).list();
        for (Review review1 : reviews)
        {
            if (review1.getClient().getClient_Id() == client.getClient_Id())
            {
                checkIfClientAlreadyWroteAReview = true;
            }
        }

        if (checkClientsInRents)
        {
            if (checkIfClientAlreadyWroteAReview) throw new InvalidClientException("Client already wrote a review");
            else
            {
                review.setClient(client);
                session.persist(review);
            }

        }
        else
        {
            throw new InvalidClientException("This client doesn't have rents");
        }

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

    public void insertRent(Rent rent, String clientName,String carModel) throws InvalidClientException, InvalidCarException, InvalidPeriodException
    {
        Session session = sessionFactory.openSession();

        Client client = new Client();
        try
        {
            client = (Client) session.createQuery("Select c From Client c Where c.client_Name =: clientName").setParameter("clientName", clientName).getSingleResult();
            rent.setClient(client);
        }
        catch (NoResultException e)
        {
            throw new InvalidClientException("Client name is not registered");
        }


        Car car = new Car();
        try
        {
            car = (Car) session.createQuery("Select c From Car c Where c.car_Model =: carModel").setParameter("carModel", carModel).getSingleResult();
            rent.setCar(car);
        }
        catch (NoResultException e)
        {
            throw new InvalidCarException("Car is not registered");
        }

        Repository<Rent> rentRepository = new Repository<>();
        List<Rent> rents = rentRepository.getList(session,"Rent");
        if (rents.isEmpty())
        {
            addRent(rent, session);
        }
        else
        {
            for (Rent rent1 : rents)
            {
                if (rent1.getCar().getCar_Id() == rent.getCar().getCar_Id()) //daca masina pe care vrom sa o inchieriem este deja inchiriata
                {
                    if (rent1.getEnd_Period().isBefore(rent.getStart_Period())) //inceputul perioadei masinii este mai mare decat sfarsitul ei de la o inchiriere anterioara
                    {
                        addRent(rent, session);
                    }
                    else throw new InvalidPeriodException("Start date is before the end period of a previous rent");
                }
                else
                {
                    addRent(rent, session);
                }
            }
        }

        session.beginTransaction().commit();
        session.close();
    }

    private void addRent(Rent rent, Session session)
    {
        if (checkStartAndEndPeriod(rent.getStart_Period(), rent.getEnd_Period()))
        {
            session.persist(rent);
            System.out.println("Rent added!");
        }
        else throw new InvalidPeriodException("Start date or End date are wrong");
    }

    private boolean checkStartAndEndPeriod(LocalDate startPeriod, LocalDate endPeriod)
    {
        if (startPeriod.isBefore(LocalDate.now())) return false;
        else
        {
            if (endPeriod.isBefore(startPeriod)) return false;
        }
        return true;
    }
}
