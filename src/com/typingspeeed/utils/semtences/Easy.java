package com.typingspeeed.utils.semtences;



import java.util.Random;

public class Easy {
    private static final String[] WORDS = {
        "Apple is red", "Orange is healthy", "Mango is sweet",
        "Grapes are black", "Banana is yellow"
    };

    public static String getRandom() {
        return WORDS[new Random().nextInt(WORDS.length)];
    }
}