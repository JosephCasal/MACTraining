package com.example.joseph.calculator1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO fix view tvValue to not go to new line when it gets full, should scroll horizontally
    // TODO fix xml and check to work on small phone
    // TODO add ANS button for previous answer
    // TODO put onclick in the xml and use view.getid


    private String[] btnStrings;
    private Button[] buttons;
    private TextView tvValue;
    int i;

    double currentAns;
    double prevAns;
    String currentOperator;
    int operatorButtonID;
    String previnput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentAns = 0;
        currentOperator = "";
//        operatorButtonID = -1;
        prevAns = 0;
        previnput = "";
        i = 0;
        btnStrings = getResources().getStringArray(R.array.buttons);
        setupButtons();
        tvValue = (TextView) findViewById(R.id.tvValue);

    }

    private void setupButtons() {
        buttons = new Button[btnStrings.length];
        buttons[0] = (Button) findViewById(R.id.btn1);
        buttons[1] = (Button) findViewById(R.id.btn2);
        buttons[2] = (Button) findViewById(R.id.btn3);
        buttons[3] = (Button) findViewById(R.id.btn4);
        buttons[4] = (Button) findViewById(R.id.btn5);
        buttons[5] = (Button) findViewById(R.id.btn6);
        buttons[6] = (Button) findViewById(R.id.btn7);
        buttons[7] = (Button) findViewById(R.id.btn8);
        buttons[8] = (Button) findViewById(R.id.btn9);
        buttons[9] = (Button) findViewById(R.id.btn10);
        buttons[10] = (Button) findViewById(R.id.btn11);
        buttons[11] = (Button) findViewById(R.id.btn12);
        buttons[12] = (Button) findViewById(R.id.btn13);
        buttons[13] = (Button) findViewById(R.id.btn14);
        buttons[14] = (Button) findViewById(R.id.btn15);
        buttons[15] = (Button) findViewById(R.id.btn16);
        buttons[16] = (Button) findViewById(R.id.btn17);
        buttons[17] = (Button) findViewById(R.id.btn18);
        buttons[18] = (Button) findViewById(R.id.btn19);
        buttons[19] = (Button) findViewById(R.id.btn20);

        for (i = 0; i < buttons.length; i++) {
            buttons[i].setText(btnStrings[i]);
            buttons[i].setBackgroundColor(0xD3D3D3);
        }
        for (i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addToExpression(((Button) view).getText().toString(), view);
                }
            });
        }

    }

    // TODO change color of button operators when pressed, like iphone changes border

    private void addToExpression(String s, View view){
        if(s.equals("C")){
            tvValue.setText("");
            currentAns = 0;
            prevAns = 0;
            previnput = "";
            if(currentOperator == ""){
            }else{
//                findViewById(operatorButtonID).setBackgroundColor(0xD3D3D3);
                currentOperator = "";
//                operatorButtonID = -1;
            }
        }else if(s.equals("DEL")){          // TODO
//            String currentString = tvValue.getText().toString();
//            tvValue.setText(currentString.substring(0, currentString.length()-1));
        }else if(s.equals("=")){        // TODO check if previnput was operator and do like iphone calculator
            calculate();
        }else if(s.equals("±")){        // TODO check if previnput was operator and do like iphone
            if(currentAns > 0)
                tvValue.setText("-" + tvValue.getText().toString());
            else if(currentAns < 0)
                tvValue.setText(tvValue.getText().toString().substring(1));
            else{       //currentans == 0

            }
            currentOperator = "";
            currentAns = -currentAns;
        }else if(s.equals("+")){
            if(currentOperator == ""){
                currentOperator = "+";
//                ((Button) view).setBackgroundColor(0x00FF00);
                prevAns = currentAns;
                currentAns = 0;
                previnput = "+";
            }else{
//                findViewById(operatorButtonID).setBackgroundColor(0xD3D3D3);
                calculate();
                prevAns = currentAns;
                currentAns = 0;
                currentOperator = "+";
//                ((Button) view).setBackgroundColor(0x00FF00);
//                operatorButtonID = view.getId();
                previnput = "+";
            }
        }else if(s.equals("-")){
            if(currentOperator == ""){
                currentOperator = "-";
//                ((Button) view).setBackgroundColor(0x00FF00);
                prevAns = currentAns;
                currentAns = 0;
                previnput = "-";
            }else{
//                findViewById(operatorButtonID).setBackgroundColor(0xD3D3D3);
                calculate();
                prevAns = currentAns;
                currentAns = 0;
                currentOperator = "-";
//                ((Button) view).setBackgroundColor(0x00FF00);
//                operatorButtonID = view.getId();
                previnput = "-";
            }
        }else if(s.equals("÷")){
            if(currentOperator == ""){
                currentOperator = "÷";
//                ((Button) view).setBackgroundColor(0x00FF00);
                prevAns = currentAns;
                currentAns = 0;
                previnput = "÷";
            }else{
//                findViewById(operatorButtonID).setBackgroundColor(0xD3D3D3);
                calculate();
                prevAns = currentAns;
                currentAns = 0;
                currentOperator = "÷";
//                ((Button) view).setBackgroundColor(0x00FF00);
//                operatorButtonID = view.getId();
                previnput = "÷";
            }
        }else if(s.equals("x")){
            if(currentOperator == ""){
                currentOperator = "x";
//                ((Button) view).setBackgroundColor(0x00FF00);
                prevAns = currentAns;
                currentAns = 0;
                previnput = "x";
            }else{
//                findViewById(operatorButtonID).setBackgroundColor(0xD3D3D3);
                calculate();
                prevAns = currentAns;
                currentAns = 0;
                currentOperator = "x";
//                ((Button) view).setBackgroundColor(0x00FF00);
//                operatorButtonID = view.getId();
                previnput = "x";
            }
        }else if(s.equals("%")){        //TODO evaluate divide by 100 currentans
            if(currentOperator == ""){

            }else{
//                findViewById(operatorButtonID).setBackgroundColor(0xD3D3D3);
                currentOperator = "";
            }
            currentAns = currentAns/100;
        } else if (s.equals(".")) {         //TODO

        } else {    // input is a number
            if(previnput.equals("") || previnput.equals("=") || currentAns == 0){
                tvValue.setText(s);
            }else{      //previnput was number
                tvValue.setText(tvValue.getText().toString() + s);
            }
            currentAns = Double.parseDouble(tvValue.getText().toString());
            previnput = s;
        }
    }

    private boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("÷"))
            return true;
        return false;
    }

    private void calculate(){

        if(currentOperator.equals("+")){
            currentAns  = prevAns + currentAns;
        }else if(currentOperator.equals("-")){
            currentAns  = prevAns - currentAns;
        }else if(currentOperator.equals("x")){
            currentAns  = prevAns * currentAns;
        }else if(currentOperator.equals("÷")){
            currentAns  = prevAns/currentAns;
        }
        tvValue.setText(Double.toString(currentAns));
        currentOperator = "";
//        findViewById(operatorButtonID).setBackgroundColor(0xD3D3D3);
//        operatorButtonID = -1;
    }

    public void printtoview(View view) {
        Button b = ((Button)view);
    }


}
