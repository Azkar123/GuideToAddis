package com.guidetoaddis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class product_detail extends AppCompatActivity {

    ImageView imgBackFromDetail;
    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);


        imgBackFromDetail = findViewById(R.id.icon_BackFromProduct);
        btnBook = findViewById(R.id.btn_Book);

        imgBackFromDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(product_detail.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(product_detail.this, PaymentScreen.class);
                startActivity(intent);

            }
        });


    }
}