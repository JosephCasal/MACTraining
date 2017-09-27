package com.example.joseph.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnUpdateValue;
    TextView tvUpdateValue;
    private EditText etUpdateValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUpdateValue = (EditText) findViewById(R.id.etInputValue);
        btnUpdateValue = (Button) findViewById(R.id.btnUpdateTextView);
        tvUpdateValue = (TextView) findViewById(R.id.tvUpdateValue);

        btnUpdateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvUpdateValue.setText(etUpdateValue.getText().toString());
            }
        });

    }
}
