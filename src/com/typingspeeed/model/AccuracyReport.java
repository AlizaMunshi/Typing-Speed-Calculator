package com.typingspeeed.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccuracyReport {
    private final String reference;
    private final String typed;

    public AccuracyReport(String reference, String typed) {
        this.reference = reference;
        this.typed = typed;
    }

    public Map<String, String> generate() {
        String[] refWords = reference.split(" ");
        String[] typedWords = typed.split(" ");

        int correct = 0, insensitive = 0;
        for (int i = 0; i < Math.min(refWords.length, typedWords.length); i++) {
            if (refWords[i].equals(typedWords[i])) correct++;
            else if (refWords[i].equalsIgnoreCase(typedWords[i])) insensitive++;
        }

        int incorrect = refWords.length - correct - insensitive;
        double accuracy = correct * (100.0 / refWords.length) +
                          insensitive * (100.0 / refWords.length) / 2;

        Map<String, String> result = new LinkedHashMap<>();
        result.put("Input Words", String.valueOf(refWords.length));
        result.put("Typed Words", String.valueOf(typedWords.length));
        result.put("Accuracy", String.format("%.2f%%", accuracy));
        result.put("Correct Words", String.valueOf(correct));
        result.put("Case-Insensitive Matches", String.valueOf(insensitive));
        result.put("Incorrect Words", String.valueOf(incorrect));

        return result;
    }
}
