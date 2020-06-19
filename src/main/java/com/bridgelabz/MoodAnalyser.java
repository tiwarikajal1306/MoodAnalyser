package com.bridgelabz;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if ( message.contains("i am in sad mood")){
            return "SAD";
        }
        else {
            return "HAPPY";
        }
    }
}
