package com.example.joseph.helloworld;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by joseph on 9/26/17.
 */

public class CodingTest {

    public static void main(String[] args) {

        //Problem 1
        // create a function to check if the number
        // is divisible by 3 then print "fizz"
        // is divisible by 5 then print "buzz"
        // is divisible by 3 and 5 then print "fizzbuzz"
        // otherwise print the number itself

        //Problem 2
        // create a function to find duplicate strings
        // in a list of string and print them

        int[] numbers = {5,3,15,8,6};
        for (int i = 0; i < numbers.length; i++) {
            checknumber(numbers[i]);
        }

        System.out.println();

        String[] strings = {"aaaa","bbb","aaaa","ccc","bbb"};
        checkstrings(strings);


    }

    public static void checknumber(int x){
        if(x % 3 == 0) {
            if(x % 5 == 0){
                System.out.println("fizzbuzz");
            }else{
                System.out.println("fizz");
            }
        }else if(x % 5 == 0){
            System.out.println("buzz");
        }else{
            System.out.println(x);
        }
    }

    public static void checkstrings(String[] strings){
        if(strings.length == 0){
            System.out.println("strings is empty");
            return;
        }
        HashSet<String> list = new HashSet<String>();
        list.add(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if(list.contains(strings[i])) {
                System.out.println("duplicate string: " + strings[i]);
            }else{
                list.add(strings[i]);
            }
        }
    }

}
