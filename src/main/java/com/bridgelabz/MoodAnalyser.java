package com.bridgelabz;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message=message;
    }

    public String analyseMood() throws MoodAnalysisException{
        try {
            if (message.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EnteredEmpty, "Entered valid msg");
            if (message.contains("i am in sad mood"))
                return "SAD";
            else if (message.contains("i am in Happy mood"))
                return "HAPPY";
        } catch (NullPointerException e) {
           throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EnteredNull, "Entered valid msg");
        }
        return null;
    }
    }


