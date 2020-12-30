package com.guidetoaddis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout dl;
    private NavigationView nv;
    ImageView imgRedCar, iconNotify, iconSearchHome;
    TextView txtViewAll, txtDealAroundAll, btn_ViewProfile;
    ImageView navicon ;
    private RegisterAPI apiService;
    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SessionManager ses = new SessionManager(getApplicationContext());
        if (ses.isLoggedIn()){
            HashMap<String, String> userDetails = ses.getUserDetails();
            token = userDetails.get("TOKEN");

        }

        dl = findViewById(R.id.activity_main);
        nv = findViewById(R.id.nv);
        View headerView = nv.getHeaderView(0);
        btn_ViewProfile = headerView.findViewById(R.id.view_Full_Profile);

        TextView username = headerView.findViewById(R.id.user_name);

        String sesname = ses.getUserDetails().get("SESNAME");
        username.setText(sesname);


        navicon = findViewById(R.id.nav_icon);
        nv.setNavigationItemSelectedListener(this);
        nv.setItemIconTintList(null);

        imgRedCar = findViewById(R.id.img_redcar);
        iconSearchHome = findViewById(R.id.icon_SearchHome);


        txtViewAll = findViewById(R.id.txt_viewAll);
        txtDealAroundAll = findViewById(R.id.txt_viewAllAround);
        iconNotify = findViewById(R.id.icon_Notification);



        // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        navicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!dl.isDrawerOpen(GravityCompat.START)) {
                    dl.openDrawer(GravityCompat.START);
                } else {
                    dl.closeDrawer(GravityCompat.START);
                }
            }
        });

        imgRedCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, product_detail.class);
                startActivity(intent);
            }
        });

        txtViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG_", token);
                apiService = AppConfig.getClient().create(RegisterAPI.class);
                Call<ListResponse> respCall = apiService.showList("GTADS@$355305789");
                respCall.enqueue(new Callback<ListResponse>() {
                    @Override
                    public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                        if (response.isSuccessful()){
                            ListResponse resp = response.body();
                            Log.d("TAG_r", resp.getMessage());

                        }else{
                            Log.d("TAG_ns", "not success");
                        }
                    }

                    @Override
                    public void onFailure(Call<ListResponse> call, Throwable t) {
                        Log.d("TAG_ex", t.getMessage());
                    }
                });

            }
        });

        txtDealAroundAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllProductActivity.class);
                startActivity(intent);
            }
        });

        btn_ViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        iconNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
        iconSearchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindCars.class);
                startActivity(intent);
            }
        });
    }





        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();


            if (id == R.id.browsecars) {
                Intent i = new Intent(this, AllProductActivity.class);
                this.startActivity(i);

            }
            /*else if (id == R.id.invitefriend) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "http://guidetoaddis.com/");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }*/
            else if (id == R.id.dashboard)
            {
                Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show();
            }

            else if(id == R.id.terms_conditions)

            {
                Intent intent = new Intent(MainActivity.this, TermsandPolicy.class);
                startActivity(intent);

            }

            else if(id == R.id.privacy_policy)

            {
                Intent intent = new Intent(MainActivity.this, TermsPrivacy.class);
                startActivity(intent);

            }


            else if (id == R.id.listcar){

                Intent intent = new Intent(MainActivity.this, CarListing.class);
                startActivity(intent);
            }
            else if (id == R.id.favorites){
                Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.triphistory) {
                Intent intent = new Intent(MainActivity.this, TripHistory.class);
                startActivity(intent);
            }

                 else if (id == R.id.reviews){
                    Intent intent = new Intent(MainActivity.this, Review.class);
                    startActivity(intent);
            }
            else if (id == R.id.account){
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
            else if (id == R.id.contact){
                Intent intent = new Intent(MainActivity.this, support_contact.class);
                startActivity(intent);
            }

            else if (id == R.id.logout){

                 SessionManager ses = new SessionManager(getApplicationContext());
                 ses.logoutUser();
                Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(intent);
            }



            dl.closeDrawer(GravityCompat.START, true);
            return false;

        }

}



