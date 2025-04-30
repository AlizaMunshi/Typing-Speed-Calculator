package com.typingspeeed.controller;


import java.util.Scanner;

import com.typingspeeed.model.Difficulty;
import com.typingspeeed.service.TypingChallenge;
import com.typingspeeed.view.Display;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Display display = new Display();

    public void start() throws InterruptedException {
        display.greet();
        Difficulty difficulty = askDifficulty();
        new TypingChallenge(difficulty).run();
    }

    private Difficulty askDifficulty() {
        System.out.println("Select difficulty level:");
        System.out.println("1 - EASY\n2 - MEDIUM\n3 - DIFFICULT");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return Difficulty.fromInt(choice);
    }
}
