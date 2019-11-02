package com.finapp.gramfin.finapp.api;

import com.finapp.gramfin.finapp.api.auth_model.AuthModel;
import com.finapp.gramfin.finapp.api.auth_model.RegModel;
import com.finapp.gramfin.finapp.api.auth_model.UserToSend;
import com.finapp.gramfin.finapp.api.auth_model.googleModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RegistrationAPI {
    @POST("/users")
    @Headers("X-Requested-With:XMLHttpRequest")
    Call<RegModel> regme(@Body UserToSend user);

    @POST("/users/login")
    @Headers("X-Requested-With: XMLHttpRequest")
    Call<AuthModel> authme(@Body UserToSend user);


    @GET("/api/google")
    @FormUrlEncoded
    Call<googleModel> loginViaGoogle();

}
