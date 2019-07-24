package com.finapp.gramfin.finapp.api;

import com.finapp.gramfin.finapp.api.question_model.AuthModel;
import com.finapp.gramfin.finapp.api.question_model.Authorize;
import com.finapp.gramfin.finapp.api.question_model.PostModel;
import com.finapp.gramfin.finapp.api.question_model.googleModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegistrationAPI {
    @POST("/api/register")
    Call<PostModel> regme(@Query("name") String userName, @Query("email") String email, @Query("password") String password);


    @POST("/api/login")
    Call<AuthModel> authme(@Query("email") String email, @Query("password") String password);


    @GET("/api/google")
    Call<googleModel> loginViaGoogle();


    @GET("/api/auth")
    Call<Authorize> auths(@Query("authorization") String Bearer);
}
