package com.example.joseph.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimalListActivity extends AppCompatActivity {

    private RecyclerView rvAnimalList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private AnimalListAdapter animalListAdapter;
    private GridLayoutManager layoutManagerGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        rvAnimalList = findViewById(R.id.rvAnimalList);

        String elephantImageURL = "https://s3-us-west-1.amazonaws.com/powr/defaults/image-slider2.jpg";
        String tigerImageUrl = "https://camo.githubusercontent.com/0716e552b587ec0c723ccdf0fe3f3824b38444a7/68747470733a2f2f662e636c6f75642e6769746875622e636f6d2f6173736574732f353938313437322f313538393035372f38363531653564302d353236322d313165332d393736372d3464653764353939353861352e6a7067";
        String birdsImageUrl = "https://cdn.colorlib.com/wp/wp-content/uploads/sites/2/2014/02/image.png";

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("mammal", "elephant", 1000, elephantImageURL));
        animalList.add(new Animal("mammal", "tiger", 1000, tigerImageUrl));
        animalList.add(new Animal("bird", "birds", 1000, birdsImageUrl));
        animalList.add(new Animal("mammal", "elephant", 1000, elephantImageURL));
        animalList.add(new Animal("mammal", "tiger", 1000, tigerImageUrl));
        animalList.add(new Animal("bird", "birds", 1000, birdsImageUrl));
        animalList.add(new Animal("mammal", "elephant", 1000, elephantImageURL));
        animalList.add(new Animal("mammal", "tiger", 1000, tigerImageUrl));
        animalList.add(new Animal("bird", "birds", 1000, birdsImageUrl));
        animalList.add(new Animal("mammal", "elephant", 1000, elephantImageURL));
        animalList.add(new Animal("mammal", "tiger", 1000, tigerImageUrl));
        animalList.add(new Animal("bird", "birds", 1000, birdsImageUrl));


//        animalList.add(new Animal("mammal", "tiger", 1000, tigerImageUrl));


        //for grid layout
        layoutManagerGrid = new GridLayoutManager(this, 3);

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        animalListAdapter = new AnimalListAdapter(this, animalList);

        rvAnimalList.setLayoutManager(layoutManager);
        rvAnimalList.setItemAnimator(itemAnimator);
        rvAnimalList.setAdapter(animalListAdapter);

    }
}
