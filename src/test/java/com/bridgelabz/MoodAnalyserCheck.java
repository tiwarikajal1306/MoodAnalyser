package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserCheck {


        @Test
        public void message_Contain_IamInSadMood_Should_return_Sad()  {
            MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals( "SAD" , mood);
        }

        @Test
        public void message_Contain_IamInHappyMood_Should_return_Happy()  {
            MoodAnalyser moodAnalyser = new MoodAnalyser("i am in Happy mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals( "SAD" , mood);

        }

    }




