package com.example.joseph.training_927;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTag";
    private EditText etFirstName;
    private EditText etLastName;
    List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (EditText) findViewById(R.id.etName);
        etLastName = (EditText) findViewById(R.id.etLastName);

    }

    public void savePerson(View view) {
        boolean isAdded = this.personList.add(new Person(etFirstName.getText().toString(), etLastName.getText().toString()));
        if (isAdded)
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Not Added", Toast.LENGTH_SHORT).show();

    }

    public void printPersons(View view) {
        for (Person p: personList){
            Log.d(TAG, "printPersons: " + p.toString());
        }
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("data", "This is the data");
        intent.putExtra("data1", "This is data1");
        startActivity(intent);
    }
}
