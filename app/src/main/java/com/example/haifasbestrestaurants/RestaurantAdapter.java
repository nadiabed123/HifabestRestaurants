package com.example.haifasbestrestaurants;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Resturant> {
    Context context;
    ArrayList<Resturant> objects;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Resturant> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects=objects;

    }
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.restaurant_information,parent,false);


        TextView name = (TextView)view.findViewById(R.id.name);
        TextView info = (TextView)view.findViewById(R.id.info);
        TextView rating = (TextView)view.findViewById(R.id.rating);
        ImageView imageView=(ImageView)view.findViewById(R.id.restaurant_pic);
        Resturant temp = objects.get(position);

        name.setText(temp.getTypeOfFood());
        info.setText(temp.getisKosher());
        rating.setText(temp.getKey());
        imageView.setImageResource(temp.getImageid());
        return view;
    }

}
