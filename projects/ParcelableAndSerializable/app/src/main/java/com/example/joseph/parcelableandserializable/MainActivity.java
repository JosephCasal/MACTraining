package com.example.joseph.parcelableandserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.joseph.parcelableandserializable.utils.CONSTANTS;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etPersonName;
    private EditText etAge;
    private EditText etGender;
    private EditText etAddress;
    private ArrayList<PersonSerializable> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPersonName = (EditText) findViewById(R.id.etPersonName);
        etAge = (EditText) findViewById(R.id.etAge);
        etGender = (EditText) findViewById(R.id.etGender);
        etAddress = (EditText) findViewById(R.id.etAddress);

        persons = new ArrayList<>();


    }


    public void sendPerson(View view) {

        String personName = etPersonName.getText().toString();
        String personAge = etAge.getText().toString();
        String personGender = etGender.getText().toString();
        String personAddress = etAddress.getText().toString();

        PersonSerializable personSerializable = new PersonSerializable(personName, personAge, personGender, personAddress);
        PersonParcelable personParcelable = new PersonParcelable(personName, personAge, personGender, personAddress);

        Intent intent = new Intent(this, PersonActivity.class);

        String action;
        switch (view.getId()){

            case R.id.btnPersonParcelable:

                action = CONSTANTS.ACTION_PERSON_PARCELABLE;
                sendPersonToPersonActivity(personParcelable, intent, action);
                startActivity(intent);

                break;
            case R.id.btnPersonSerializable:

                action = "PersonSerializable";
                sendPersonToPersonActivity(personSerializable, intent, action);
                startActivity(intent);

                break;
            case R.id.btnSharePerson:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This person's name is " + personName);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

                break;

        }

    }

    public void addToList(View view) {

        String personName = etPersonName.getText().toString();
        String personAge = etAge.getText().toString();
        String personGender = etGender.getText().toString();
        String personAddress = etAddress.getText().toString();

        persons.add(new PersonSerializable(personName, personAge, personGender, personAddress));

    }

    public void sendList(View view) {
        Intent intent = new Intent(this, PersonList.class);
        intent.putExtra("list", persons);
        startActivity(intent);
    }


    private void sendPersonToPersonActivity(Object person, Intent intent, String action){
        if(person instanceof PersonParcelable)
            intent.putExtra(action, (PersonParcelable) person);
        else
            intent.putExtra(action, (PersonSerializable) person);
        intent.setAction(action);
        startActivity(intent);
    }

}
