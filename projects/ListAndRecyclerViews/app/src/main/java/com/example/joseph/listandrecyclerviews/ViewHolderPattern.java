package com.example.joseph.listandrecyclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewHolderPattern extends AppCompatActivity {

    private ListView listView;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_holder_pattern);

        listView = (ListView) findViewById( R.id.listView );

        /*
        String[] arr = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_view_item, arr));
        */

        personList = new ArrayList<>();

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
        personList.add(new Person("Joseph", "24"));

        ListViewHolderAdapter psa = new ListViewHolderAdapter( this, R.layout.list_item, personList);

        listView.setAdapter( psa );

    }
}
