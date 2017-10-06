package com.example.joseph.listandrecyclerviews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 10/5/17.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder>{

    List<Person> personList = new ArrayList<>();
    public static final String TAG = "PersonListAdapter";

    public PersonListAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        Log.d(TAG, "onCreateViewHolder: ");

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.tvPersonName.setText(person.getName());
        holder.tvPersonAge.setText(person.getAge());

        Log.d(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount: ");

        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPersonName;
        TextView tvPersonAge;

        public ViewHolder(View itemView) {
            super(itemView);

            tvPersonName = (TextView) itemView.findViewById(R.id.tvPersonName);
            tvPersonAge = (TextView) itemView.findViewById(R.id.tvPersonAge);
        }
    }

}
