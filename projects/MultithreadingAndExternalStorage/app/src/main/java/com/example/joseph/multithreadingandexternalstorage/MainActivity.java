package com.example.joseph.multithreadingandexternalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnRead;
    private EditText etName;
    private EditText etAge;
    private EditText etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etGender = (EditText) findViewById(R.id.etGender);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnRead = (Button) findViewById(R.id.btnRead);

    }


    public void saveFile(View view) {

        String writeData = etName + " " + etAge + " " + etGender;
        FileStorageTask storageTask = new FileStorageTask(writeData);
        storageTask.execute();

    }

    public void readFile(View view) {



    }
}
