package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

