package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

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
        //String mood = null;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void messageContain_Empty_ShouldThrowException() {

        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.EnteredEmpty, e.type);
        }
    }
    //TC 4.1
    @Test
    public void givenMoodAnalyserClass_WhenProper_shouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood","com.bridgelabz.MoodAnalyser",String.class);
        Assert.assertTrue(new MoodAnalyser("I am in happy mood").equals(moodAnalyser));
    }
    //Tc4.2
    @Test
    public void givenMoodAnalyserClass_WhenNotProper_ShouldThrowException()  {
        try {
             MoodAnalyserFactory.createMoodAnalyser("I am in happy mood","com.bridgelabz.Mood",String.class);
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    //tc4.3
    @Test
    public void givenMoodAnalyserMethod_WhenNotProper_ShouldThrowException()  {
        try {
          MoodAnalyserFactory.createMoodAnalyser("I am in happy mood","com.bridgelabz.MoodAnalyser",Integer.class);
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
}
