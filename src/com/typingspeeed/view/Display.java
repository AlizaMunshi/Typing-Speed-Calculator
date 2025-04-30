package com.typingspeeed.view;

import com.typingspeeed.model.TypingResult;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Display {
    public void greet() {
       System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       System.out.println("\t\t\t\t\t\t\t\t\t👋WELOCME TO TYPING SPEED GAME");
       System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void showText(String text) throws InterruptedException {
    	System.out.print("\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("..............................................................................................");
		TimeUnit.SECONDS.sleep(2);
		System.out.print("\t\t\t\t\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println();
		
		
		
		System.out.println("\t\t\t\t\t\t\t\s"+text);
		
		System.out.print("\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("..............................................................................................");
		TimeUnit.SECONDS.sleep(2);
		System.out.print("\t\t\t\t\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println();
    }

    public void showResult(TypingResult result) {
        System.out.println("\n✅ RESULTS:");
        System.out.println("WPM: " + result.getWPM());
        System.out.println("CPM: " + result.getCPM());
        System.out.println("Expertise: " + result.getExpertiseLevel());
        System.out.println("Feedback: " + result.getSpeedFeedback());

        Map<String, String> accuracy = result.getAccuracyReport().generate();
        System.out.println("\n📊 Accuracy Report:");
        accuracy.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

