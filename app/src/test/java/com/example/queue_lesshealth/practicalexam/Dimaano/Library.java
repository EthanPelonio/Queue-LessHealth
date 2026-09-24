package com.example.queue_lesshealth.practicalexam.Dimaano;

import java.util.Scanner;
import java.util.ArrayList;

    public class library {
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
            // to fill
        }

        public void registerUser(Scanner scanner) {}
        public void addBook(Scanner scanner) {}
        public void displayBooks() {}
        public void searchBook(Scanner scanner) {}
        public void displayStatus() {}
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

        public void addBook(String t, String a, int y) {}
        public void displayAll() {}
        public void searchByKeyword(String k) {}
        public int getTotal() { return 0; }
        public boolean isEmpty() { return true; }
    }

