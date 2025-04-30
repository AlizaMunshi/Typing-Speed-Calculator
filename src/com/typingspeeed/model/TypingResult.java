package com.typingspeeed.model;

public class TypingResult {
    private final String reference;
    private final String typed;
    private final double duration;

    public TypingResult(String reference, String typed, double duration) {
        this.reference = reference;
        this.typed = typed;
        this.duration = duration;
    }

    public int getWPM() {
        int chars = typed.length();
        return (int) ((((double) chars / 5) / duration) * 60);
    }

    public int getCPM() {
        return getWPM() * 5;
    }

    public String getExpertiseLevel() {
        int wpm = getWPM();
        return wpm < 40 ? "BEGINNER" : (wpm <= 50 ? "INTERMEDIATE" : "EXPERT");
    }

    public String getSpeedFeedback() {
        int wpm = getWPM();
        return wpm < 40 ? "Slow speed, more practice needed." :
               wpm <= 50 ? "Average speed. Keep practicing." :
               "Excellent speed!";
    }

    public AccuracyReport getAccuracyReport() {
        return new AccuracyReport(reference, typed);
    }
}
