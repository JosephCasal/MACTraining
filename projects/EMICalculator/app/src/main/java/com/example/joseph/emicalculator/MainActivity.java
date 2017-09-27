package com.example.joseph.emicalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etPrincipal;
    EditText etInterestRate;
    EditText etTime;
    TextView tvEMI;
    TextView tvTotal;
    Button btnUpdateEMI;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrincipal = (EditText) findViewById(R.id.etPrincipal);
        etInterestRate = (EditText) findViewById(R.id.etInterestRate);
        etTime = (EditText) findViewById(R.id.etTime);
        tvEMI = (TextView) findViewById(R.id.tvEMI);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        btnUpdateEMI = (Button) findViewById(R.id.btnUpdateEMI);

        spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Time_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        btnUpdateEMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double p;
                double r;
                double t;
                try {
                    p = Double.parseDouble(etPrincipal.getText().toString());
                    r = Double.parseDouble(etInterestRate.getText().toString()) / 100;
                    t = Double.parseDouble(etTime.getText().toString());
                }catch (Exception e){
                    tvEMI.setText("Invalid Input");
                    tvTotal.setText("");
                    return;
                }

                String timeFormat = spinner.getSelectedItem().toString();
                if(timeFormat.equals("Years")){
                    t = t*12;
                }

//                EMI = (P * R/12) * [ (1+R/12)^N] / [ (1+R/12)^N-1]
                double emi = (p*(r/12)) * (Math.pow((1+(r/12)),t) / (Math.pow(1+(r/12),t)-1));

                DecimalFormat df = new DecimalFormat("0.00");
                df.setRoundingMode(RoundingMode.HALF_UP);

                tvEMI.setText(df.format(emi) + " Monthly Payments");

                double total = emi*t;

                tvTotal.setText(df.format(total) + " Total Repayment");

            }
        });

    }
}
