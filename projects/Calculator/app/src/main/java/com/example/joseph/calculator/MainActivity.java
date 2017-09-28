package com.example.joseph.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    // TODO fix view tvValue to not go to new line when it gets full, should scroll horizontally
    // TODO fix xml and check to work on small phone
    // TODO add ANS button for previous answer
    // TODO put onclick in the xml and use view.getid


    private String[] btnStrings;
    private Button[] buttons;
    private TextView tvValue;
    int i;
    Expression e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        }
        for (i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addToExpression(((Button) view).getText().toString());
                }
            });
        }

    }

    private void addToExpression(String s){
        if(s.equals("C")){
            tvValue.setText("");
        }else if(s.equals("DEL")){
            String currentString = tvValue.getText().toString();
            tvValue.setText(currentString.substring(0, currentString.length()-1));
        }else if(s.equals("=")){
            calculate();
        }else if(s.equals("±")){
            tvValue.setText(tvValue.getText().toString() + "±");
        }else{
            tvValue.setText(tvValue.getText().toString() + s);
        }
    }

    private void calculate(){
        Expression e = new Expression()
    }

    //*******************
    public void printtoview(View view) {
        Button b = ((Button)view);
    }
}
