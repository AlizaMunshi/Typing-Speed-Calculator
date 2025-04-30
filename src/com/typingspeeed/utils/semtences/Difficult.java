package com.typingspeeed.utils.semtences;

import java.util.Random;

public class Difficult {
	private static final String[] WORDS = {
	        "Please take your dog, Cali, out for a walk – he really needs some exercise!",
	        "What a beautiful day it is on the beach, here in beautiful and sunny Hawaii.",
	        "Rex Quinfrey, a renowned scientist, created plans for an invisibility machine!!!.",
	        "Do you know why all those chemicals are so hazardous to the environment?",
	        "You never did tell me how many copper pennies were in that jar; how come?"
	    };

	    public static String getRandom() {
	        return WORDS[new Random().nextInt(WORDS.length)];
	    }

}
