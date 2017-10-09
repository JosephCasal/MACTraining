package com.example.joseph.codingtestweek2;

/**
 * Created by joseph on 10/6/17.
 */

public class EncodingProblem {

    /*
    [Problem 1] In this problem we are asking for implementation of a function, f, that encodes a String.
The function f shall accept a String as an input and return the encoded String as a return value.
The encoding algorithm replaces every character in the string with the letter that has exactly the same position when counting backwards from letter “z” (with alphabet sort order in mind.)
Non-alphabet characters are ignored.
Here are three examples:
[a] Letter “a" is replaced by letter “z” (because “a” is the first letter of alphabet and “z” is the first letter when counted from the end of the alphabet list.)
[b] Letter “c” is replaced by letter “x” (because “c” is the third letter of alphabet and “x” is the third letter of alphabet when counted backwards from letter “z".)
[c] Letter “p” is replaced by letter “k” (because “p” is the 16th letter of alphabet and “k” is the 16th letter when counted backwards from letter “z".)
 
Therefore, when string “acp” is encoded, the return value is string “zxk”.
Please write and submit this function with any unit tests that you would like to include.
What would be the result of encoding the String “Errors in strategy cannot be correct through tactical maneuvers”?
     */

    /*
    [Problem 2] In this problem we are asking for implementation of a function, g, that returns the frequency of alphabet letters in a given string ignoring upper/lower case issues.
Use whatever programming language you are most comfortable with, although we prefer to see standard scripting languages used.
The return format is best demonstrated in an example.
Suppose you are given the String “Hello there! Apple!"
The function g shall return the following structure:
{
        a:1,
        b:0,
        c:0,
        d:0,
        e:4,
        f:0,
        g:0,
        h:2,
        i:0,
       j:0,
       k:0,
       l:3,
       m:0,
      n:0,
     o:1,
     p:2,
     q:0,
     r:1,
     s:0,
     t:1,
     u:0,
     v:0,
     w:0,
     x:0,
     y:0,
     z:0
}
     */


    public static void main(String[] args) {

        System.out.println("acp = " + encode("acp"));
        System.out.println("Errors in strategy cannot be correct through tactical maneuvers = " +
                encode("Errors in strategy cannot be correct through tactical maneuvers"));

        System.out.println();

        int[] freq = frequencies("Hello there! Apple!");
        for (int i = 0; i < freq.length; i++) {
            System.out.println(((char)('a' + i)) + ":" + freq[i]);
        }

    }

    public static String encode(String s){

        int length = s.length();
        char[] chars = new char[length];

        for (int i = 0; i < length; i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){    //if is alphabet letter lowercase, encode
                chars[i] = ( (char) ('z' - (s.charAt(i)-'a')) );
            }else{
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){   //if is alphabet letter uppercase, encode
                    chars[i] = ( (char) ('Z' - (s.charAt(i)-'A')) );
                }else{          //if its not alphabet ignore
                    chars[i] = s.charAt(i);
                }
            }
        }

        return new String(chars);

    }

    public static int[] frequencies(String s){

        int[] frequencies = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){   //if is alphabet letter lowercase
                frequencies[s.charAt(i)-'a']++;
            }else{
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){   //if is alphabet letter uppercase
                    frequencies[s.charAt(i)-'A']++;
                }else{      //if its not alphabet ignore

                }
            }
        }

        return frequencies;

    }

}
