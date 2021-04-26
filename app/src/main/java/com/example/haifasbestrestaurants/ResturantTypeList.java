package com.example.haifasbestrestaurants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ResturantTypeList extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_type_list);

        listView = findViewById(R.id.restauranttypelist);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("sandwich restaurants");
        arrayList.add("meat restaurants");
        arrayList.add("kosher restaurants");
        arrayList.add("vegan restaurants 1");
        arrayList.add("hidden gems");
        arrayList.add("pizza restaurants");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String name= arrayList.get(position);
               if (name.equals("sandwich restaurants")) {
                   Intent intent = new Intent(ResturantTypeList.this, Restaurantslist.class);
                   startActivity(intent);
               }


            }
        });

    }
    //option menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.usermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                Intent intent = new Intent(ResturantTypeList.this , ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.signOut:
                Intent intent1 = new Intent(ResturantTypeList.this , MainActivity.class);
                startActivity(intent1);
                break;
                //1. add the third option
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //2. dialog
    }
}