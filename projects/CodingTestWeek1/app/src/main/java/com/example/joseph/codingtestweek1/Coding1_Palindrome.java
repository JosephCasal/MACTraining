package com.example.joseph.codingtestweek1;

/**
 * Created by joseph on 9/29/17.
 */

public class Coding1_Palindrome {

//    1. Method to tell you if a string is a palindrome

    public static void main(String[] args) {

        String s = "abcddcba";

        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s){
        int j = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            if(i >= j){
                return true;
            }
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
        }

        return true;
    }

}
