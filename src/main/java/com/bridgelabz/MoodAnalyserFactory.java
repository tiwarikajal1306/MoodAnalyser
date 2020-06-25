package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String... parameters) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(parameters[1]);
            Class<?> moodAnalyserMethod = Class.forName("java.lang." +parameters[2]);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(moodAnalyserMethod);
            Object moodObj = moodConstructor.newInstance(parameters[0]);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ClassNotFound, "class not found");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.MethodNotFound, "Method not found");
        }
        return null;
    }
}

