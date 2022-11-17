package com.typingspeeed;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Display {
	
	public void greet() {
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWELOCME TO TYPING SPEED GAME");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void showText(String inputText) throws InterruptedException {
		
		System.out.print("\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("..............................................................................................");
		TimeUnit.SECONDS.sleep(2);
		System.out.print("\t\t\t\t\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println();
		
		
		
		System.out.println("\t\t\t\t\t\t\t\s"+inputText);
		
		System.out.print("\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("..............................................................................................");
		TimeUnit.SECONDS.sleep(2);
		System.out.print("\t\t\t\t\t\t\t\t\t\t");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println();
		
	}

	public void showResult(int wpm, int cpm, Map<String, String> accuracyResult ,String experty, String suggestion) {
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("\t\t\t\t\tWPM:"+wpm);
		System.out.println("\t\t\t\t\t\t\t\t\t\tCPM:"+cpm);
		//System.out.println();
		System.out.println("\t\t\t\t\tAccuracy:"+accuracyResult.get("accuracy")+"%"+"\t\t\t\t\t\t\t\t\tExpert Level:"+experty);
		//System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tExperty Level:"+experty);
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t\tNo of Input Words\t\t:"+accuracyResult.get("No of Input Words"));
		System.out.println("\t\t\t\t\t\t\t\t\t\tNo of Typed Words\t\t:"+accuracyResult.get("No of Typed Words"));
		System.out.println("\t\t\t\t\t\t\t\t\t\tCase Sensitive Word Count\t:"+accuracyResult.get("Case Sensitive Word Count"));
		System.out.println("\t\t\t\t\t\t\t\t\t\tCase Insensitive Word Count\t:"+accuracyResult.get("Case Insensitive Word Count"));
		System.out.println("\t\t\t\t\t\t\t\t\t\tIncorrect Word Count\t\t:"+accuracyResult.get("Incorrect Word Count"));
		System.out.println();
		System.out.println("\t\t\tSuggestions:"+suggestion+accuracyResult.get("suggestions"));
		
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
	}

}
