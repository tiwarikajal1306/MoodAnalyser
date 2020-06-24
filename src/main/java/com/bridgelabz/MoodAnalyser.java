package com.bridgelabz;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message)
    {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalyserException {
        try {
            if (message.length() == 0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.EnteredEmpty, "Entered valid msg");
            if (message.contains("i am in sad mood"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.EnteredNull, "Entered valid msg");
        }

    }
}