package com.example.joseph.listandrecyclerviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPersonList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private List<Person> personList;
    ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPersonList = (RecyclerView) findViewById(R.id.rvPersonList);

        personList = new ArrayList<>();
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));
        personList.add(new Person("Joseph", "24"));

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        PersonListAdapter personListAdapter = new PersonListAdapter(personList);

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeFlag(itemTouchHelper.ACTION_STATE_SWIPE, itemTouchHelper.LEFT ) | makeFlag(itemTouchHelper.ACTION_STATE_DRAG, itemTouchHelper.UP | itemTouchHelper.DOWN);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                if(viewHolder.getAdapterPosition() == target.getAdapterPosition()){

                    return true;
                }

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });

        rvPersonList.setLayoutManager(layoutManager);
        rvPersonList.setItemAnimator(itemAnimator);
        rvPersonList.setAdapter(personListAdapter);

        itemTouchHelper.attachToRecyclerView(rvPersonList);
    }

    public void nextList(View view) {
        Intent intent = new Intent(this, ViewHolderPattern.class);
        startActivity(intent);
    }

}
