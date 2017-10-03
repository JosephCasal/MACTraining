package com.example.joseph.codingtestweek1;

/**
 * Created by joseph on 9/29/17.
 */

public class Coding4_ArmstrongNumber {

//    4: Simple Java Program to check or find if a number is Armstrong number or not.
//    An Armstrong number of three digit is a number whose sum of cubes of its digit is
//    equal to its number. For example 153 is an Armstrong number of 3 digit
//    because 1^3+5^3+3^3 or 1+125+27=153

    public static void main(String[] args) {

        int n = 153;

        System.out.println(isArmstrong(n));

    }

    public static boolean isArmstrong(int n){

        String digits = Integer.toString(n);

        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Math.pow((digits.charAt(i) - '0'), digits.length());
        }

        if(sum == n)
            return true;
        else
            return false;

    }

}
