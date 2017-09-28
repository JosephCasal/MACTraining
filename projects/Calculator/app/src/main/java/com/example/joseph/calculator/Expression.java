package com.example.joseph.calculator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by joseph on 9/27/17.
 */

class Expression {

    ArrayList<String> strings;

    public Expression() {
        strings = new ArrayList<>();
    }

    private boolean isOperator(String s){
        if(s == "+" || s == "-" || s == "*" || s == "÷" || s == "±" || s == "(" || s == ")")
            return true;
        return false;
    }

    //return 1 if a>b, return 0 if a==b, return -1 if a<b
    private int compareOperators(char a, char b){
        if(a == '+' || a == '-'){
            if(b == '+' || b == '-'){
                return 0;
            }else{
                return -1;
            }
        }else if(a == 'x' || a == '÷'){
            if(b == '+' || b == '-'){
                return 1;
            }else if(b == 'x' || b == '÷'){
                return 0;
            }else{
                return -1;
            }
        }else if(a == '±'){
            if(b == '±'){
                return 0;
            }else if(b == '('){
                return -1;
            }else{
                return 1;
            }
        }else{ // then a == '('
            if(b == '('){
                return 0;
            }else{
                return 1;
            }
        }
    }

}
