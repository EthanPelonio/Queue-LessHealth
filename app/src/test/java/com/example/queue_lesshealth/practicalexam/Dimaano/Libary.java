package com.example.queue_lesshealth.practicalexam.Dimaano;

import java.util.Scanner;
import java.util.ArrayList;

    public class Library {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            LibrarySystem library = new LibrarySystem();
            library.run(scanner);
            scanner.close();
        }
    }

class LibrarySystem {
    private String userName;
    private BookCollection collection;

    public LibrarySystem() {
        userName = "";
        collection = new BookCollection();
    }

    public void run(Scanner scanner) {
        int choice = 0;
        while (choice != 6) {
            System.out.println("\n===== LIBRARY BOOK SYSTEM =====");
            System.out.println("1. Register User");
            System.out.println("2. Add Book");
            System.out.println("3. Show All Books");
            System.out.println("4. Search Book");
            System.out.println("5. Show Total & Status");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

                        choice = scanner.nextInt();
                        scanner.nextLine(); // Clear Enter key

                        switch (choice) {
                            case 1:
                                registerUser(scanner);
                                break;
                            case 2:
                                addBook(scanner);
                                break;
                            case 3:
                                displayBooks();
                                break;
                            case 4:
                                searchBook(scanner);
                                break;
                            case 5:
                                displayStatus();
                                break;
                            case 6:
                                System.out.println("Thank you for using Library System!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                }
