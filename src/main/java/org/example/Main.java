package org.example;

/*
* Welcome to the Rent a car!
Please choose one of the following options:
0 - End session
1 - Register a Client
2 - Display all Clients
3 - Register a Car
4 - Display all Cars
5 - Register a Review
6 - Display all Reviews
7 - Add a Rent
* */

import org.example.Entities.*;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        //---------- Menu ----------
        System.out.println("Welcome to the Rent a car!\n" +
                "Please choose one of the following options:\n" +
                "0 - End session\n" +
                "1 - Register a Car\n" +
                "2 - Display all Cars\n" +
                "3 - Register a Client\n" +
                "4 - Display all Clients\n" +
                "5 - Register a Review\n" +
                "6 - Display all Reviews\n" +
                "7 - Add a Rent");
        Scanner scanner = new Scanner(System.in);
        int menuNumber = scanner.nextInt();
        scanner.nextLine();
        while (menuNumber != 0) {
            if (menuNumber > 7 || menuNumber < 0) {
                System.out.println("Wrong number!\n" + "Select another option!");
                System.out.println("Welcome to the Rent a car!\n" +
                        "Please choose one of the following options:\n" +
                        "0 - End session\n" +
                        "1 - Register a Car\n" +
                        "2 - Display all Cars\n" +
                        "3 - Register a Client\n" +
                        "4 - Display all Clients\n" +
                        "5 - Register a Review\n" +
                        "6 - Display all Reviews\n" +
                        "7 - Add a Rent");
                menuNumber = scanner.nextInt();
                scanner.nextLine();
            } else {
                CompanyDAO companyDAO = new CompanyDAO();
                switch (menuNumber) {
                    case 1: {
                        System.out.println("1 was selected");
                        System.out.print("Car model: ");
                        companyDAO.insertCar(new Car(scanner.nextLine()));
                        System.out.println();
                        break;
                    }
                    case 2: {
                        System.out.println("2 was selected");
                        System.out.println("Cars for rent: ");
                        List<Car> cars = new ArrayList<>();
                        for(Car car : companyDAO.displayCars(cars))
                        {
                            System.out.println(car.toString());
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("3 was selected");
                        System.out.println("Write client name: ");
                        String clientName = scanner.nextLine();
                        Client client = new Client(clientName);
                        companyDAO.insertClient(client);
                        break;
                    }
                    case 4: {
                        System.out.println("4 was selected");
                        System.out.println("Clients with rent: ");
                        List<Client> clients = new ArrayList<>();
                        for (Client client : companyDAO.displayClients(clients))
                        {
                            System.out.println(client.toString());
                        }
                        break;
                    }
                    case 5: {
                        System.out.println("5 was selected");
                        System.out.println("Write the name of the client: ");
                        String clientName = scanner.nextLine();

                        System.out.println("Write a review: ");
                        String reviewDescription = scanner.nextLine();
                        companyDAO.insertReview(new Review(reviewDescription), clientName);
                        break;
                    }
                    case 6: {
                        System.out.println("6 was selected");
                        System.out.println("All reviews: ");
                        List<Review> reviews = new ArrayList<>();
                        for (Review review : companyDAO.displayReviews(reviews))
                        {
                            System.out.println(review.toString());
                        }
                        break;
                    }
                    case 7: {
                        System.out.println("7 was selected");

                        System.out.println("Write the client name: ");
                        String clientName = scanner.nextLine();

                        System.out.println("Choose a car from the list below:");
                        List<Car> cars = new ArrayList<>();
                        for(Car car : companyDAO.displayCars(cars))
                        {
                            System.out.println(car.getCar_Model());
                        }
                        System.out.println("Write the car  model: ");
                        String carModel = scanner.nextLine();

                        System.out.println("Write the price for the rent: ");
                        double rentPrice = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Write the start of the rent (dd-MM-yyyy): ");
                        String startDate = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate startPeriod = LocalDate.parse(startDate, formatter);

                        System.out.println("Write the end of the rent (dd-MM-yyyy): ");
                        String endDate = scanner.nextLine();
                        LocalDate endPeriod = LocalDate.parse(endDate, formatter);

                        Rent rent = new Rent(rentPrice, startPeriod, endPeriod);
                        companyDAO.insertRent(rent, clientName, carModel);
                        System.out.println();
                        break;
                    }
                }
                System.out.println("Welcome to the Rent a car!\n" +
                        "Please choose one of the following options:\n" +
                        "0 - End session\n" +
                        "1 - Register a Cars\n" +
                        "2 - Display all Car\n" +
                        "3 - Register a Clients\n" +
                        "4 - Display all Client\n" +
                        "5 - Register a Review\n" +
                        "6 - Display all Reviews\n" +
                        "7 - Add a Rent");
                menuNumber = scanner.nextInt();
                scanner.nextLine();
            }

        }
        scanner.close();
        System.out.println("Session ended!");



    }
}