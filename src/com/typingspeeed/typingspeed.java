/**
 * 
 */
package com.typingspeeed;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author U6064295
 *
 */

public class typingspeed {

	/**
	 * @param args
	 * 
	 */
	static String[] easy = { "Apple is red", "Orange is healthy", "Mango is sweet", "Grapes are black",
			"Banana is yellow" };
	static String[] difficult = { " Please take your dog, Cali, out for a walk – he really needs some exercise!",
			"What a beautiful day it is on the beach, here in beautiful and sunny Hawaii.",
			"Rex Quinfrey, a renowned scientist, created plans for an invisibility machine!!!.",
			"Do you know why all those chemicals are so hazardous to the environment?",
			"You never did tell me how many copper pennies where in that jar; how come?" };
	static String[] medium = {"Finally he began typing.","He hung up and texted her quickly, typing with his thumb.","What sorts of search phrases do you think they will be typing in on Google?",
			"He sobered, staring at the screen a moment before typing again.","She heard him typing in the background."};
	
	public static void main(String[] args) throws InterruptedException {
		Display display=new Display();
		Scanner sc = new Scanner(System.in);
		//greet the player
		display.greet();
		
/*		User has option to select the difficulty level of typing based on users comfortability. User can type 
		•	1 for Easy text
		•	2 for Intermediate level difficult text
		•	3 for Difficult level text.
		If user type any number other than 1,2 or 3 then by default Easy text is displayed.
*/

		System.out.println("Please select the difficulty level");
		System.out.println("Type 1 for EASY \nType 2 for MEDIUM \nType 3 for DIFFICULT");
		System.out.println();
		System.out.print("Enter your choice here:");
		int i=sc.nextInt();
		System.out.println();
		switch(i) {
		case 1:System.out.println("Your selected difficulty level is: EASY");
			   selectRandomWordAndCalculateSpeed(easy);
			   break;
		case 2:System.out.println("Your selected difficulty level is: MEDIUM");
		   	   selectRandomWordAndCalculateSpeed(medium);
		       break;
		case 3:System.out.println("Your selected difficulty level is: DIFFICULT");
		   	   selectRandomWordAndCalculateSpeed(difficult);
		       break;
		default:System.out.println("By default selected difficulty level is: EASY");
		   		selectRandomWordAndCalculateSpeed(easy);
		   		break;
		}

	}

	private static void selectRandomWordAndCalculateSpeed(String[] sampleWords) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Display display=new Display();
		String speedSuggestion=null;
		String expertyLevel=null;
		System.out.println("Game is starting");
		System.out.println("Type the text appearing on the screen");
		Random random=new Random();
		int n=sampleWords.length;
		String inputText=sampleWords[random.nextInt(n-1)];
		display.showText(inputText);
		System.out.print("\t\t\t\t\t\tType Here:");
		double start=LocalTime.now().toNanoOfDay();
		String typedText=sc.nextLine();
		double end=LocalTime.now().toNanoOfDay();
		double duration=end-start;
		double seconds=duration/1000000000.0;
		int numChars=typedText.length();
		int wpm=(int) ((((double) numChars/5)/seconds)*60);
		int cpm=wpm*5;
		if(wpm<40) {
			speedSuggestion="Your typing speed is slow.More practice needed to improve efficiency.";
			expertyLevel="BEGINNER";
		} else if(wpm>40 && wpm<50) {
			speedSuggestion="Your typing speed is average.Practice needed to improve efficiency.";
			expertyLevel="INTERMEDIATE";
		} else {
			speedSuggestion="Your typing speed is very productive.";
			expertyLevel="EXPERT";
		}
		Map<String, String> accuracyResult=getAccuracyResult(typedText, inputText);
		display.showResult(wpm, cpm,accuracyResult,expertyLevel,speedSuggestion);
		
		
	}
	

	private static Map<String, String> getAccuracyResult(String typedText, String inputText) {
		int inputwordCount=inputText.split(" ").length;
		String[] words=typedText.split(" ");
		int correctWordCount=0;
		int caseinsensitiveWordCount = 0;
		int incorrectWordCount=0;
		double accuracyForEachWord = 100 / inputwordCount;
		double accuracyOfTyping=0;
		int difference=inputwordCount-words.length;
		
		Map<String, String> accuracyMap = new HashMap<>();
		if (typedText.equals(inputText)) {
			accuracyMap.put("No of Input Words", Integer.toString(inputwordCount));
			accuracyMap.put("No of Typed Words", Integer.toString(words.length));
			accuracyMap.put("accuracy", "100");
			accuracyMap.put("Case Sensitive Word Count", Integer.toString(correctWordCount));
			accuracyMap.put("Incorrect Word Count", Integer.toString(incorrectWordCount));
			accuracyMap.put("Case Insensitive Word Count", Integer.toString(caseinsensitiveWordCount));
			accuracyMap.put("suggestions", "Your typing accuracy is Excellent. Suggestions not needed on that front.");
		} else {
			for (int i = 0; i < words.length; i++) {
				if (inputText.contains(words[i])) {
					correctWordCount +=1;
				} else if (inputText.toLowerCase().contains(words[i].toLowerCase())) {
					caseinsensitiveWordCount += 1;
				}
			}
			incorrectWordCount = inputwordCount - correctWordCount - caseinsensitiveWordCount;
			accuracyOfTyping=correctWordCount*accuracyForEachWord+(caseinsensitiveWordCount*accuracyForEachWord/2);
			accuracyMap.put("No of Input Words", Integer.toString(inputwordCount));
			accuracyMap.put("No of Typed Words", Integer.toString(words.length));
			accuracyMap.put("accuracy", Double.toString(accuracyOfTyping));
			accuracyMap.put("Case Sensitive Word Count", Integer.toString(correctWordCount));
			accuracyMap.put("Incorrect Word Count", Integer.toString(incorrectWordCount));
			accuracyMap.put("Case Insensitive Word Count", Integer.toString(caseinsensitiveWordCount));
			
			if (difference < 0) {
				accuracyMap.put("suggestions", "You have typed extra word/words which are not displayed on screen.Type carefully.");
			} else if (difference > 1) {
				accuracyMap.put("suggestions", "You have missed some word/words from displayed text on screen.Type carefully.Type carefully.");
			} else {
				accuracyMap.put("suggestions", "You have enterd all the words.Work on case sensitivity and accuracy.");
			}
		}
		return accuracyMap;
	}

}


//else if (typedText.equalsIgnoreCase(inputText)) {
//	char typedTextArray[] = typedText.toCharArray();
//	char inputTextArray[] = inputText.toCharArray();
//	int caseinsensitiveCharacterCount = 0;
////	for (int i = 0; i < inputTextArray.length; i++) {
////		if (typedTextArray[i] != inputTextArray[i]) {
////			caseinsensitiveCharacterCount += 1;
////		}
////	}
//	for(int i=0; i<words.length;i++) {
//		if(inputText.contains(words[i])) {
//			correctWordCount+=words[i].length();
//		} else if(inputText.toLowerCase().contains(words[i].toLowerCase())) {
//			caseinsensitiveWordCount+=words[i].length();
//		}
//	}
//	int caseInsenitiveTyping = caseinsensitiveCharacterCount / inputTextArray.length * 100;
//	int fianl_accuracy = 100 - (caseInsenitiveTyping / 2);
//	accuracyMap.put("accuracy", Integer.toString(fianl_accuracy));
//	accuracyMap.put("case insenitive Typing", Integer.toString(caseInsenitiveTyping));
//	accuracyMap.put("suggestions", "Your typing is case insensitive. Work on the case sensitive typing.");
//}
