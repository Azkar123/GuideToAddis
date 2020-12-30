package com.guidetoaddis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView imgCarAnim;

    private static int SPLASH_SCREEN_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        imgCarAnim = findViewById(R.id.car_anim);

        Animation an2= AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        imgCarAnim.setAnimation(an2);

        SessionManager ses = new SessionManager(getApplicationContext());
        if (ses.isLoggedIn()){
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i=new Intent(SplashActivity.this,
                            SigninActivity.class);
                    startActivity(i);
                    finish();

                }
            }, SPLASH_SCREEN_TIME_OUT);

        }






    }
}