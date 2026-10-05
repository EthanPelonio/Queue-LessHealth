package com.example.queue_lesshealth.practicalexam.Biscocho.Cinema;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

  public class cinema {

        static Scanner scanner = new Scanner(System.in);

        static ArrayList<String> movies = new ArrayList<>();
        static ArrayList<Double> prices = new ArrayList<>();

        cinema() {
        }

        public static void main(String[] args) {

            // Movies
            movies.add("Avengers: Endgame");
            prices.add(250.00);

            movies.add("Spider-Man");
            prices.add(220.00);

            movies.add("The Batman");
            prices.add(200.00);

            movies.add("Frozen");
            prices.add(180.00);

            while (true) {

                System.out.println("\n============================");
                System.out.println("       CINEMA SYSTEM");
                System.out.println("============================");
                System.out.println("1. View Movies");
                System.out.println("2. Buy Ticket");
                System.out.println("3. Exit");
                System.out.print("Choose: ");

                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        viewMovies();
                        break;

                    case 2:
                        buyTicket();
                        break;

                    case 3:
                        System.out.println("Thank you for visiting!");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        // Display movies
        static void viewMovies() {

            System.out.println("\n-------- MOVIES --------");

            for (int i = 0; i < movies.size(); i++) {

                System.out.println(
                        (i + 1) + ". " +
                                movies.get(i) +
                                " - PHP " +
                                prices.get(i)
                );
            }
        }

        // Buy ticket
        static void buyTicket() {

            viewMovies();

            System.out.print("\nSelect movie: ");
            int movieChoice = scanner.nextInt();

            if (movieChoice < 1 || movieChoice > movies.size()) {
                System.out.println("Invalid movie.");
                return;
            }

            System.out.print("Number of tickets: ");
            int tickets = scanner.nextInt();

            if (tickets <= 0) {
                System.out.println("Invalid number of tickets.");
                return;
            }

            String movie = movies.get(movieChoice - 1);
            double price = prices.get(movieChoice - 1);

            double total = price * tickets;

            System.out.println("\n============================");
            System.out.println("        TICKET RECEIPT");
            System.out.println("============================");
            System.out.println("Movie: " + movie);
            System.out.println("Tickets: " + tickets);
            System.out.println("Price: PHP " + price);
            System.out.println("Total: PHP " + total);
            System.out.println("============================");

            System.out.println("Booking successful!");
        }

        public static cinema newcinema() {
            return new cinema();
        }
    }






