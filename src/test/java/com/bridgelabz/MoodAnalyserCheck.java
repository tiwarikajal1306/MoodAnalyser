package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserCheck {


        @Test
        public void messageContain_IamInSadMood_ShouldReturn_Sad()  {
            MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals( "SAD" , mood);
        }

        @Test
        public void messageContain_IamInHappyMood_ShouldReturn_Happy()  {
            MoodAnalyser moodAnalyser = new MoodAnalyser("i am in Happy mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals( "HAPPY" , mood);
        }

        @Test
        public void messageContain_NullMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    }




