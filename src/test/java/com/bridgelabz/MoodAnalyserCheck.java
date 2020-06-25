package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserCheck {

    @Test
    public void messageContain_IamInSadMood_ShouldReturn_Sad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
        try {
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void messageContain_IamInHappyMood_ShouldReturn_Happy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in Happy mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void messageContain_NullMood_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void messageContain_Empty_ShouldThrowException() {

        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    //TC 4.1
    @Test
    public void givenMoodAnalyserClass_WhenProper_shouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("com.bridgelabz.MoodAnalyser","String","I am in happy mood");
        Assert.assertTrue(new MoodAnalyser("I am in happy mood").equals(moodAnalyser));
    }
    //Tc4.2
    @Test
    public void givenMoodAnalyserClass_WhenNotProper_ShouldThrowException()  {
        try {
             MoodAnalyserReflector.createMoodAnalyser("com.bridgelabz.Mood","String","I am in happy mood");
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    //tc4.3
    @Test
    public void givenMoodAnalyserMethod_WhenNotProper_ShouldThrowException()  {
        try {
          MoodAnalyserReflector.createMoodAnalyser("com.bridgelabz.MoodAnalyser","Integer","I am in happy mood");
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    //uc6.1
    @Test
    public void givenMessage_WhenHappy_ShouldReturnHappy() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.bridgelabz.MoodAnalyser","String","I am in happy mood");
            Assert.assertEquals("HAPPY", MoodAnalyserReflector.callAnalyseMood(moodAnalyser));
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }

    }
}
