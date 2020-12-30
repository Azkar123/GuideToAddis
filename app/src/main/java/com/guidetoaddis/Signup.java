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

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {

    private static final String TAG = "TAG_Signup";
    TextView txtLoginPage, btnRegister;
    private RegisterAPI apiService;
    private EditText fname, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtLoginPage = findViewById(R.id.txt_register);
        btnRegister  = findViewById(R.id.bRegister);

        email = (EditText) findViewById(R.id.email_reg);
        fname = (EditText) findViewById(R.id.fname_reg);
        password = (EditText) findViewById(R.id.pass_reg);

        txtLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(view -> {
            Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
            getAllFiles();
        });
    }

    private void getAllFiles() {
        String f_name = fname.getText().toString();
        String e_mail = email.getText().toString();
        String p_asswd = password.getText().toString();
        String p_hone = "9990012345";



        Log.d(TAG, "uploading is started....");
        apiService = AppConfig.getClient().create(RegisterAPI.class);
        Call<RegistrationResponse> respCall = apiService.takeSignupDetails(f_name, e_mail, p_asswd, "9990012345");
        respCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                RegistrationResponse result = response.body();
                //boolean successful = response.isSuccessful();
                if(response.isSuccessful()){
                    Log.d(TAG, "line no 84 => " + result.getStatus());
                    if (result.getStatus() == 1) {
                        Log.d(TAG, "line no 86 => " + result.getMessage());
                        Toast.makeText(getApplicationContext(), "Result " + result.getMessage(), Toast.LENGTH_LONG).show();
                              Toast.makeText(Signup.this, "Please login", Toast.LENGTH_SHORT).show();
              Intent intent = new Intent(Signup.this, SigninActivity.class);
              startActivity(intent);
                    } else {
                        Log.d(TAG, "line no 295 => " + result.getMessage());
                    }
                } else {
                    Log.d(TAG, "not successfull =>" + String.valueOf(response.errorBody()) + "<---->" + response.message());
                    Toast.makeText(getApplicationContext(), "Result " + String.valueOf(response.errorBody() + "<---->" + response.message()), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Log.d(TAG+"_exception", t.getMessage());

            }
        });
    }
}

