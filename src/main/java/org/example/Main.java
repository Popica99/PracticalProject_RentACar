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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //---------- Menu ----------
        System.out.println("Welcome to the Rent a car!\n" +
                "Please choose one of the following options:\n" +
                "0 - End session\n" +
                "1 - Register a Client\n" +
                "2 - Display all Clients\n" +
                "3 - Register a Car\n" +
                "4 - Display all Cars\n" +
                "5 - Register a Review\n" +
                "6 - Display all Reviews\n" +
                "7 - Add a Rent");
        Scanner scanner = new Scanner(System.in);
        int menuNumber = scanner.nextInt();
        while (menuNumber != 0)
        {
            if (menuNumber > 7 || menuNumber < 0)
            {
                System.out.println("Wrong number!\n" + "Select another option!");
                System.out.println("Welcome to the Rent a car!\n" +
                    "Please choose one of the following options:\n" +
                    "0 - End session\n" +
                    "1 - Register a Client\n" +
                    "2 - Display all Clients\n" +
                    "3 - Register a Car\n" +
                    "4 - Display all Cars\n" +
                    "5 - Register a Review\n" +
                    "6 - Display all Reviews\n" +
                    "7 - Add a Rent");
                menuNumber = scanner.nextInt();
            }
            else
            {
                switch (menuNumber)
                {
                    case 1:
                    {
                        System.out.println("1 was selected");
                        break;
                    }
                    case 2:
                    {
                        System.out.println("2 was selected");
                        break;
                    }
                    case 3:
                    {
                        System.out.println("3 was selected");
                        break;
                    }
                    case 4:
                    {
                        System.out.println("4 was selected");
                        break;
                    }
                    case 5:
                    {
                        System.out.println("5 was selected");
                        break;
                    }
                    case 6:
                    {
                        System.out.println("6 was selected");
                        break;
                    }
                    case 7:
                    {
                        System.out.println("7 was selected");
                        break;
                    }

                }
                System.out.println("Welcome to the Rent a car!\n" +
                        "Please choose one of the following options:\n" +
                        "0 - End session\n" +
                        "1 - Register a Client\n" +
                        "2 - Display all Clients\n" +
                        "3 - Register a Car\n" +
                        "4 - Display all Cars\n" +
                        "5 - Register a Review\n" +
                        "6 - Display all Reviews\n" +
                        "7 - Add a Rent");
                menuNumber = scanner.nextInt();
            }

        }
        System.out.println("Session ended!");
    }
}