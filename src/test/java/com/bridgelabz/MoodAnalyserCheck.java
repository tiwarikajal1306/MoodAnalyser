package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserCheck {


        @Test
        public void messageContain_IamInSadMood_ShouldReturn_Sad()  {
            MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
            String mood = null;
            try {
                mood = moodAnalyser.analyseMood();
            } catch (MoodAnalysisException e) {
                e.printStackTrace();
            }
            Assert.assertEquals( "SAD" , mood);
        }

        @Test
        public void messageContain_IamInHappyMood_ShouldReturn_Happy()  {
            MoodAnalyser moodAnalyser = new MoodAnalyser("i am in Happy mood");
            String mood = null;
            try {
                mood = moodAnalyser.analyseMood();
            } catch (MoodAnalysisException e) {
                e.printStackTrace();
            }
            Assert.assertEquals( "HAPPY" , mood);
        }

        @Test
        public void messageContain_NullMood_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = null;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            moodAnalyser.analyseMood();
            //Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e){
            e.printStackTrace();
        }
    }
        @Test
        public void messageContain_Empty_ShouldThrowException(){

            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = null;
            try {
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(MoodAnalysisException.class);
                moodAnalyser.analyseMood();
            } catch (MoodAnalysisException e) {
                e.printStackTrace();
            }
        }
    }




