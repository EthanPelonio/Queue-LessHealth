package com.example.queue_lesshealth.practicalexam.Dimaano;

import java.util.Scanner;

public class ArcadeMenu {

    private int tokenCount;
    private int ticketCount;

    public ArcadeMenu() {
        tokenCount = 0;
        ticketCount = 0;
    }

    public void start(Scanner scanner) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArcadeMenu arcadeSystem = new ArcadeMenu();
        arcadeSystem.start(scanner);

        scanner.close();
    }
}
