package com.example.queue_lesshealth.practicalexam.Buendia;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class GymAccessTest {

    @Test
    public void testGymFlow() {

        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING GYM TEST DATA ---");

        // Step 1: Enter Gym
        automatedInput.append("1\n");

        // Step 2: Select Regular membership
        automatedInput.append("1\n");

        // Step 3: Exit
        automatedInput.append("3\n");

        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        automatedInput.toString().getBytes()
                );

        Scanner scanner = new Scanner(inputStream);

        GymMenu gymSystem = new GymMenu();
        gymSystem.start(scanner);
    }
}