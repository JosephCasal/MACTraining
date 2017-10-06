package com.example.joseph.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPersonsList;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPersonsList = findViewById(R.id.rvPersonsList);

        //create person objects
        personList = new ArrayList<>();
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Jason", "24"));
        personList.add(new Person("MAC", "24"));
        personList.add(new Person("Ryne", "29"));
        personList.add(new Person("Jarret", "27"));
        personList.add(new Person("Manny", "28"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        PersonListAdapter personListAdapter = new PersonListAdapter(personList);

        rvPersonsList.setLayoutManager(layoutManager);
        rvPersonsList.setItemAnimator(itemAnimator);
        rvPersonsList.setAdapter(personListAdapter);

    }

    public void goToAnimals(View view) {

        Intent intent = new Intent(this, AnimalListActivity.class);
        startActivity(intent);

    }
}
