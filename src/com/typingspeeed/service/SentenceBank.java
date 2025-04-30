package com.typingspeeed.service;

import com.typingspeeed.model.Difficulty;
import com.typingspeeed.utils.semtences.Difficult;
import com.typingspeeed.utils.semtences.Easy;
import com.typingspeeed.utils.semtences.Medium;



public class SentenceBank {
    public static String getRandomText(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> Easy.getRandom();
            case MEDIUM -> Medium.getRandom();
            case DIFFICULT -> Difficult.getRandom();
        };
    }
}
