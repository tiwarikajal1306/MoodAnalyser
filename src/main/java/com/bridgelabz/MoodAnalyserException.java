package com.bridgelabz;

public class MoodAnalyserException extends Exception {
    enum ExceptionType {
        EnteredNull, EnteredEmpty, ClassNotFound,MethodNotFound,FieldNotFound;
    }
    ExceptionType type;

    public MoodAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}