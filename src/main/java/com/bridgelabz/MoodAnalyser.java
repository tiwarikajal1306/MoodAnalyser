package com.bridgelabz;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message=message;
    }

    public String analyseMood() {
        try {
            if (message.contains("i am in sad mood"))
                return "SAD";
            else if (message.contains("i am in Happy mood"))
                return "HAPPY";
        } catch (NullPointerException e) {
            return "HAPPY";
        }
        return null;
    }
    }


