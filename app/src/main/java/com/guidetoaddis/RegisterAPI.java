package com.guidetoaddis;

import android.widget.EditText;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("capi/signup.php")
    Call<RegistrationResponse> takeSignupDetails(
            @Field("full_name") String fname,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone
    );

    @FormUrlEncoded
    @POST("capi/login.php")
    Call<RegistrationResponse> takeloginDetails(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("capi/list_vehicle.php")
    Call<ListResponse> showList(
            @Field("token") String token
    );
}
