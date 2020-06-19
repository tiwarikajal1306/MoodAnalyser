package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserCheck {

        MoodAnalyser moodAnalyser = new MoodAnalyser();

        @Test
        public void message_Contain_IamInSadMood_Should_return_Sad()  {
            String mood = moodAnalyser.analyseMood("i am in sad mood");
            Assert.assertEquals( "SAD" , mood);
        }

        @Test
        public void message_Contain_IamInHappyMood_Should_return_Happy()  {
            String mood = moodAnalyser.analyseMood("i am in any mood");
            Assert.assertEquals( "HAPPY" , mood);

        }

    }




