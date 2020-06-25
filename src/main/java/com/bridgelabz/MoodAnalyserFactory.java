package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String message,String className,Class<?> methodName) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(methodName);
            Object moodObj = moodConstructor.newInstance(message);
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

