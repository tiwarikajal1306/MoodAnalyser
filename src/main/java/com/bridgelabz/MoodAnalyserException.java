package com.bridgelabz;

public class MoodAnalyserException extends Exception {
    enum ExceptionType {
        EnteredNull, EnteredEmpty
    }
    ExceptionType type;

    public MoodAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}