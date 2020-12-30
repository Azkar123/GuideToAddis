package com.guidetoaddis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AllProductActivity extends AppCompatActivity {

    ImageView iconChooseFilter, iconBackFromAllProduct;
    CardView carCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        iconChooseFilter = findViewById(R.id.icon_choose_filter);
        iconBackFromAllProduct = findViewById(R.id.icon_backfromproduct);
        carCard = findViewById(R.id.CarCard);


        iconBackFromAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllProductActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        carCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllProductActivity.this, product_detail.class);
                startActivity(intent);
            }
        });

        iconChooseFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               final Dialog dialog = new Dialog(AllProductActivity.this);
                dialog.setContentView(R.layout.filter_dialogue);

                Button btnAddFilter = dialog.findViewById(R.id.btn_SubmitFilter);

                btnAddFilter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(AllProductActivity.this, "Filter Added", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                  dialog.show();



            }
        });

    }
}