package com.guidetoaddis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Review extends AppCompatActivity {

    ImageView backReview;
    TextView btnReviewSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        backReview = findViewById(R.id.icon_Back_Review);
        btnReviewSubmit = findViewById(R.id.btnReviewSubmit);

        backReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Review.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnReviewSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Review.this, "Thank You!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}