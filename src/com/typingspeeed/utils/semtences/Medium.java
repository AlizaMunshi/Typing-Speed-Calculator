package com.typingspeeed.utils.semtences;

import java.util.Random;

public class Medium {
	private static final String[] WORDS = {
	        "Finally he began typing.",
	        "He hung up and texted her quickly, typing with his thumb.",
	        "What sorts of search phrases do you think they will be typing in on Google?",
	        "He sobered, staring at the screen a moment before typing again.",
	        "She heard him typing in the background."
	    };

	    public static String getRandom() {
	        return WORDS[new Random().nextInt(WORDS.length)];
	    }

}
