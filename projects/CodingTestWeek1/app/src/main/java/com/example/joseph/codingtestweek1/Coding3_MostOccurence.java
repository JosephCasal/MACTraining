package com.example.joseph.codingtestweek1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by joseph on 9/29/17.
 */

public class Coding3_MostOccurence {

//    3. Create a function to find the most occurrence of a integer value given an integer array.
//    {2,3,4,5,5,6,7}

    public static void main(String[] args) {

        int[] integers = {2,3,4,5,5,6,7};

        mostOccurrence(integers);

    }

    public static void mostOccurrence(int[] integers){

        HashMap<Integer, Integer> map = new HashMap<>();

        int maxKey = 0;
        int maxValue = 0;
        boolean empty = true;
        int newValue;

        for (int i = 0; i < integers.length; i++) {
            if(map.containsKey(integers[i])){
                newValue = map.get(integers[i])+1;
                map.put(integers[i], newValue);
                if(newValue > maxValue){
                    maxKey = integers[i];
                    maxValue = newValue;
                }
            }else{
                map.put(integers[i], 1);
                if(empty){
                    maxKey = integers[i];
                    maxValue = 1;
                    empty = false;
                }
            }
        }

        if(empty)
            System.out.println("there are no integers");
        else
            System.out.println(maxKey + " is the most occurring integer with " + map.get(maxKey) + " occurrences");
    }

}
