package com.guidetoaddis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity {

    private static final String TAG = "TAG_Login_";
    TextView txtRegisterPage, txtForgotPasswordPage, btLogin;
    EditText emailSignin, pwdSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        txtRegisterPage = findViewById(R.id.txt_register);
        btLogin = findViewById(R.id.bLogin);
        txtForgotPasswordPage = findViewById(R.id.txt_forgotpwdpage);
        emailSignin =(EditText) findViewById(R.id.email_signin);
        pwdSignin = (EditText) findViewById(R.id.pwd_signin);

        txtRegisterPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, Signup.class);
                startActivity(intent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SigninActivity.this, "Login", Toast.LENGTH_SHORT).show();

               /* Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(intent);*/

                getAllFilesLogin();



            }
        });

        txtForgotPasswordPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SigninActivity.this, ForgotPassword.class);
                startActivity(intent);


            }
        });
    }

    private void getAllFilesLogin() {
        String emailSign = emailSignin.getText().toString();
        String pwdSign = pwdSignin.getText().toString();
        Log.d(TAG+"email", emailSign + ", " + pwdSign);
//

        RegisterAPI signinAPI = AppConfig.getClient().create(RegisterAPI.class);
        Call<RegistrationResponse> registrationResponseCall = signinAPI.takeloginDetails(emailSign, pwdSign);
        registrationResponseCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {

                if(response.isSuccessful()){
                    RegistrationResponse body = response.body();
                    if(body.getStatus() == 1){
                    Log.d(TAG, body.getStatus().toString());
                    Log.d(TAG, body.getMessage());
                    SessionManager ses = new SessionManager(getApplicationContext());
                        Result result = body.getResult();
                    ses.createLoginSession(result.getFullName(),result.getEmail(),result.getToken());




                      Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                        startActivity(intent);
                  }else{
                        Log.d(TAG+"zero", body.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Log.d(TAG+"exception",t.getMessage());
            }
        });


    }
}