package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserCheck {

        MoodAnalyser moodAnalyser = new MoodAnalyser();

        @Test
        public void testMoodAnalysis ()  {
            String mood = moodAnalyser.analyseMood("this is sad mood");
            Assert.assertEquals( "SAD" , mood);
        }

        @Test
        public void HappyMoods()  {
            String mood = moodAnalyser.analyseMood("this is sad mood");
            Assert.assertEquals( "HAPPY" , mood);

        }

    }




