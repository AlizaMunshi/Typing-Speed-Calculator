package com.typingspeeed.model;

public enum Difficulty {
    EASY, MEDIUM, DIFFICULT;

    public static Difficulty fromInt(int choice) {
        return switch (choice) {
            case 2 -> MEDIUM;
            case 3 -> DIFFICULT;
            default -> EASY;
        };
    }
}


