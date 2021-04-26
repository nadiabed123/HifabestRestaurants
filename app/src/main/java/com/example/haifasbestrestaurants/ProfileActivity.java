package com.example.haifasbestrestaurants;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mimageView;
    Button takepicture;
    private static final int REQUEST_IMAGE_CAPTURE = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mimageView = findViewById(R.id.image);
        takepicture=findViewById(R.id.takepicture);
        takepicture.setOnClickListener(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            mimageView.setImageBitmap(bitmap);

        }

    }

    @Override
    public void onClick(View v) {
        if (v==takepicture) {
            Intent imageTakeintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(imageTakeintent, 1);
        }
    }
    //create xml with imageview and button and text view
    //textview -- Miss Haneen -- firebase email
    //imageView - nadi image from camera
    //button -- nadi will do camera
}