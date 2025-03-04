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

import org.example.Entities.Client;
import org.example.Entities.Car;
import org.example.Entities.CompanyDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //---------- Create DataBase ----------
        String url = "jdbc:mysql://localhost:3306/Rent_A_Car";
        String user = "root";
        String password = "SDA123";
        String clientTable = "CREATE TABLE IF NOT EXISTS client(\n" +
                "client_Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "client_Name VARCHAR(50) NOT NULL,\n" +
                "car_Id INT\n" +
                ");";
        String rentTable = "CREATE TABLE IF NOT EXISTS rent(\n" +
                "rent_Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "rent_Price DOUBLE,\n" +
                "rent_Period DATE,\n" +
                "car_Id INT\n" +
                ");";
        String carTable = "CREATE TABLE IF NOT EXISTS car(\n" +
                "car_Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "car_Model VARCHAR(50) NOT NULL ,\n" +
                "rent_Id INT\n" +
                ");";
        String reviewTable = "CREATE TABLE IF NOT EXISTS review(\n" +
                "review_Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "description_Review VARCHAR(255) NOT NULL ,\n" +
                "client_Id INT\n" +
                ");";

        try (Connection connection = DriverManager.getConnection(url, user, password); Statement statement = connection.createStatement())
        {
            statement.executeUpdate(clientTable);
            statement.executeUpdate(rentTable);
            statement.executeUpdate(carTable);
            statement.executeUpdate(reviewTable);

            CompanyDAO companyDAO = new CompanyDAO(connection);

            //---------- Menu ----------
            System.out.println("Welcome to the Rent a car!\n" +
                    "Please choose one of the following options:\n" +
                    "0 - End session\n" +
                    "1 - Register a Car\n" +
                    "2 - Display all Car\n" +
                    "3 - Register a Client\n" +
                    "4 - Display all Client\n" +
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
                            "2 - Display all Car\n" +
                            "3 - Register a Client\n" +
                            "4 - Display all Client\n" +
                            "5 - Register a Review\n" +
                            "6 - Display all Reviews\n" +
                            "7 - Add a Rent");
                    menuNumber = scanner.nextInt();
                    scanner.nextLine();
                } else {
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
                            break;
                        }
                        case 3: {
                            System.out.println("3 was selected");
                            System.out.println("Write client name: ");
                            String clientName = scanner.nextLine();

                            System.out.println("Write car model");
                            String carModel = scanner.nextLine();
                            Client client = new Client(clientName);
                            companyDAO.registerClient(client,carModel);
                            break;
                        }
                        case 4: {
                            System.out.println("4 was selected");
                            break;
                        }
                        case 5: {
                            System.out.println("5 was selected");
                            break;
                        }
                        case 6: {
                            System.out.println("6 was selected");
                            break;
                        }
                        case 7: {
                            System.out.println("7 was selected");
                            break;
                        }
                    }
                    System.out.println("Welcome to the Rent a car!\n" +
                            "Please choose one of the following options:\n" +
                            "0 - End session\n" +
                            "1 - Register a Car\n" +
                            "2 - Display all Car\n" +
                            "3 - Register a Client\n" +
                            "4 - Display all Client\n" +
                            "5 - Register a Review\n" +
                            "6 - Display all Reviews\n" +
                            "7 - Add a Rent");
                    menuNumber = scanner.nextInt();
                }

            }
            scanner.close();
            System.out.println("Session ended!");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
}