package com.example.joseph.listandrecyclerviews;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joseph on 10/5/17.
 */

public class ListViewHolderAdapter extends ArrayAdapter<Person>{
    public ListViewHolderAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if( convertView == null ) {
            //inflate the view with custom layout xml
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);

            //bind the views
            holder = new ViewHolder();
            holder.nameTextView = (TextView) convertView.findViewById( R.id.tvPersonName );
            holder.surnameTextView = (TextView) convertView.findViewById( R.id.tvPersonAge );

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        //set the values
        Person person = getItem( position );

        holder.nameTextView.setText( person.getName() );
        holder.surnameTextView.setText( person.getAge() );

        return convertView;
    }

    static class ViewHolder {
        private TextView nameTextView;
        private TextView surnameTextView;
    }
}
