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

    public void registerUser(Scanner scanner) {
        System.out.println("\n===== USER REGISTRATION =====");
        System.out.print("Enter your name: ");
        userName = scanner.nextLine();
        System.out.println("User registered successfully!");
    }

    public void addBook(Scanner scanner) {
        System.out.println("\n===== ADD NEW BOOK =====");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Clear Enter key

        if (year <= 0) {
            System.out.println("Year must be valid.");
            return;
        }

        collection.addBook(title, author, year);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        System.out.println("\n========== BOOK LIST ==========");
        if (collection.isEmpty()) {
            System.out.println("No books in collection.");
            return;
        }
        collection.displayAll();
    }

    public void searchBook(Scanner scanner) {
        System.out.println("\n===== SEARCH BOOK =====");
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();
        collection.searchByKeyword(keyword);
    }

    public void displayStatus() {
        System.out.println("\n===== COLLECTION STATUS =====");
        if (userName.equals("")) {
            System.out.println("User: Guest");
        } else {
            System.out.println("User: " + userName);
        }
        System.out.println("Total Books: " + collection.getTotal());
        System.out.println(collection.isEmpty() ? "Status: Empty" : "Status: Has books");
    }
}

class BookCollection {
    private ArrayList<String> titles;
    private ArrayList<String> authors;
    private ArrayList<Integer> years;

    public BookCollection() {
        titles = new ArrayList<>();
        authors = new ArrayList<>();
        years = new ArrayList<>();
    }

    public void addBook(String title, String author, int year) {
        titles.add(title);
        authors.add(author);
        years.add(year);
    }

    public void displayAll() {
        System.out.println("--------------------------------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println((i+1) + ". \"" + titles.get(i) + "\"");
            System.out.println("   Author: " + authors.get(i) + " | Year: " + years.get(i));
        }
        System.out.println("--------------------------------");
    }

    public void searchByKeyword(String keyword) {
        boolean found = false;
        System.out.println("Search Results:");
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("- " + titles.get(i) + " by " + authors.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching books found.");
        }
    }

