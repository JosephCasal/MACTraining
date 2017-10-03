package com.example.joseph.parcelableandserializable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseph.parcelableandserializable.utils.CONSTANTS;

public class PersonActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvAge;
    private TextView tvGender;
    private TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvAddress = (TextView) findViewById(R.id.tvAddress);

        tvAddress.setcolo

        String action = getIntent().getAction();



        switch (action) {
            case CONSTANTS.ACTION_PERSON_PARCELABLE:

                break;
            case "PersonSerializable":

                break;
        }

        PersonParcelable personParcelable = getIntent().getParcelableExtra("PersonParcelable");
        if(personParcelable != null){
            Toast.makeText(this, personParcelable.getName(), Toast.LENGTH_SHORT).show();

            tvName.setText(personParcelable.getName());
            tvAge.setText(personParcelable.getAge());
            tvGender.setText(personParcelable.getGender());
            tvAddress.setText(personParcelable.getAddress());

        }else{
            PersonSerializable personSerializable = (PersonSerializable) getIntent().getSerializableExtra("PersonSerializable");
            Toast.makeText(this, personSerializable.getName(), Toast.LENGTH_SHORT).show();

            tvName.setText(personSerializable.getName());
            tvAge.setText(personSerializable.getAge());
            tvGender.setText(personSerializable.getGender());
            tvAddress.setText(personSerializable.getAddress());

        }

    }
}
