package com.typingspeeed.service;

import com.typingspeeed.model.Difficulty;
import com.typingspeeed.model.TypingResult;
import com.typingspeeed.view.Display;

import java.time.LocalTime;
import java.util.Scanner;

public class TypingChallenge {
    private final Difficulty difficulty;
    private final Scanner scanner = new Scanner(System.in);
    private final Display display = new Display();

    public TypingChallenge(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void run() throws InterruptedException {
        System.out.println("\nGame is starting...");
        String text = SentenceBank.getRandomText(difficulty);
        display.showText(text);

        System.out.print("\t\t\t\t\tType here: ");
        double start = LocalTime.now().toNanoOfDay();
        String typed = scanner.nextLine();
        double end = LocalTime.now().toNanoOfDay();

        double duration = (end - start) / 1_000_000_000.0;
        TypingResult result = new TypingResult(text, typed, duration);
        display.showResult(result);
    }
}

