package com.example.queue_lesshealth.practicalexam.Pelonio;

import java.util.ArrayList;

public class Order {

    private ArrayList<String> itemNames;
    private ArrayList<Double> prices;
    private ArrayList<Integer> quantities;

    public Order() {

        itemNames = new ArrayList<>();
        prices = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(String itemName, double price, int quantity) {

        itemNames.add(itemName);
        prices.add(price);
        quantities.add(quantity);
    }

    public double calculateSubtotal() {

        double subtotal = 0;

        for (int i = 0; i < itemNames.size(); i++) {

            subtotal += prices.get(i) * quantities.get(i);
        }

        return subtotal;
    }

    public void displayItems() {

        if (itemNames.isEmpty()) {
            System.out.println("No items ordered.");
            return;
        }

        for (int i = 0; i < itemNames.size(); i++) {

            double itemTotal =
                    prices.get(i) * quantities.get(i);

            System.out.printf(
                    "%dx %-12s PHP %.2f%n",
                    quantities.get(i),
                    itemNames.get(i),
                    itemTotal
            );
        }
    }

    public int getItemCount() {

        return itemNames.size();
    }

    public void clearOrder() {

        itemNames.clear();
        prices.clear();
        quantities.clear();
    }
}