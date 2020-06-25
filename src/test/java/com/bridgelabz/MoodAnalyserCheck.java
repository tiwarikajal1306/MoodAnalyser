package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

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


    @Test
    public void givenMoodAnalyser_WhenProper_shouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"),moodAnalyser);
    }
}




