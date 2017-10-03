package com.example.joseph.codingtestweek1;

/**
 * Created by joseph on 9/29/17.
 */

public class Coding2_SingletonThreadSafe {

//    2. Create a singleton class and make it thread safe

    private static Coding2_SingletonThreadSafe instance = null;

    private Coding2_SingletonThreadSafe() {
    }

    public static synchronized Coding2_SingletonThreadSafe getInstance() {
        if (instance == null) {
            instance = new Coding2_SingletonThreadSafe();
        }
        return instance;
    }

}
