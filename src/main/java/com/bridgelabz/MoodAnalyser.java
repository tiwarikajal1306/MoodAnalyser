package com.bridgelabz;

import java.util.Objects;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message)
    {
        this.message = message;
    }

    public MoodAnalyser() {

    }

    public String analyseMood(String message) throws MoodAnalyserException{
        this.message=message;
        return analyseMood();
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

    public boolean equals(MoodAnalyser o) {
        if (this.message.equals(o.message)){
            return true;
        }
        else
            return false;
    }
}