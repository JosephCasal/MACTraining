package com.example.joseph.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 10/4/17.
 */

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {

    Context context;

    List<Animal> list = new ArrayList<>();

    public AnimalListAdapter(Context context, List<Animal> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {

        if(position % 2 == 0){
            return 1;
        }else{
            return 2;
        }

//        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        switch (viewType){
            case 1:
                context = parent.getContext();

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_item, parent, false);

//                return new ViewHolder(view);
                break;
            case 2:
                context = parent.getContext();

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_item2, parent, false);

//                return new ViewHolder(view);
                break;
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Animal animal = list.get(position);
        holder.tvAnimalName.setText(animal.getName());
        holder.tvAnimalType.setText(animal.getType());
        holder.tvAnimalWeight.setText(String.valueOf(animal.getWeight()));

        //use glide to load the image in the imageview
        Glide.with(context).load(animal.getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvAnimalName;
        TextView tvAnimalType;
        TextView tvAnimalWeight;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivAnimal);
            tvAnimalName = itemView.findViewById(R.id.tvAnimalName);
            tvAnimalType = itemView.findViewById(R.id.tvAnimalType);
            tvAnimalWeight = itemView.findViewById(R.id.tvAnimalWeight);

        }
    }

}
