package com.example.joseph.parcelableandserializable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class PersonList extends AppCompatActivity {

    private static final String TAG = "PersonListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        ArrayList<PersonSerializable> persons = (ArrayList<PersonSerializable>) getIntent().getSerializableExtra("list");

        for (PersonSerializable p: persons){
            String s = p.getName() + " " + p.getGender() + " " + p.getAge() + " " + p.getAddress();
            Log.d(TAG, s);
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }

    }
}
