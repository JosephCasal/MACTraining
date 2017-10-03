package com.example.joseph.savingdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PersonListActivity extends AppCompatActivity {

    private ListView lvPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        lvPersons = (ListView) findViewById(R.id.lvPersons);

        //dummy datat
        String[] values = new String[]{
                "value1",
                "value2",
                "value3",
                "value4",
        };

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Person> personList = databaseHelper.getPersonList();

        //displaying dummy data
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
//        lvPersons.setAdapter(adapter);

        //displaying persons in listivew
//        ArrayAdapter<Person> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personList);
//        lvPersons.setAdapter(adapter);

        //displaying persons in listview with custom adapter
        PersonListAdapter personListAdapter = new PersonListAdapter(this, R.layout.custom_list_item, personList);
        lvPersons.setAdapter(personListAdapter);

    }
}
