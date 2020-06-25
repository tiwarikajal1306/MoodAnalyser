package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static MoodAnalyser createMoodAnalyser(String... parameters) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(parameters[0]);
            if(parameters.length>1) {
                Class<?> moodAnalyserMethod = Class.forName("java.lang." + parameters[1]);
                Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(moodAnalyserMethod);
                Object moodObj = moodConstructor.newInstance(parameters[2]);
                return (MoodAnalyser) moodObj;
            }
            else {
                Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
                Object moodObj = moodConstructor.newInstance();
                return (MoodAnalyser) moodObj;
            }
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
    public static String callAnalyseMood(MoodAnalyser moodAnalyser) throws MoodAnalyserException {
        try {
            return moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.MethodNotFound, "Method not found");
        }
    }
    public static void setMood(MoodAnalyser moodAnalyser,String fieldName,String fieldValue) throws MoodAnalyserException {
        try
        {
            Field field = moodAnalyser.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyser, fieldValue);
        } catch (NoSuchFieldException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.FieldNotFound, "ERROR: NO SUCH FIELD");
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}

