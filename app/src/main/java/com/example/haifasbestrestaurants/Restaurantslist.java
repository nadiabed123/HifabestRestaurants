package com.example.haifasbestrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Restaurantslist extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Resturant> listRestaurant;
    private RestaurantAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantslist);
        Resturant r1= new Resturant("Bracha","notkosher",R.drawable.bracha,"4.5");
        Resturant r2= new Resturant("b","mohammed",R.drawable.bracha,"4");
        Resturant r3= new Resturant("b","osama",R.drawable.bracha,"3");
        Resturant r4= new Resturant("b","anan",R.drawable.bracha,"2");
        Log.d("waseem","3");
        listRestaurant=new ArrayList<Resturant>();
        listRestaurant.add(r1); listRestaurant.add(r2);
        listRestaurant.add(r3); listRestaurant.add(r4);
        adapter= new RestaurantAdapter(this,0,listRestaurant);
        lv=findViewById(R.id.lv);
        lv.setAdapter(adapter);

    }

    //add new class for custom adapter from Miss Haneen's Video
    //and connect it to this activity
}