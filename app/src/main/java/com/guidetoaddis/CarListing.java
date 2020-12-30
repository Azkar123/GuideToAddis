package com.guidetoaddis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CarListing extends AppCompatActivity {
    ImageView imgcarListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_listing);

        imgcarListing = findViewById(R.id.icon_backfromCarListing);

        imgcarListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarListing.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}