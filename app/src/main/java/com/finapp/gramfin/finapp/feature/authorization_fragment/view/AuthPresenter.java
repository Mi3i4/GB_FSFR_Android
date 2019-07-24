package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import com.finapp.gramfin.finapp.api.RegistrationAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthPresenter {

    public RegistrationAPI authme() {
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://185.178.46.111/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit1.create(RegistrationAPI.class);


    }


    public RegistrationAPI loginViaGoogle() {
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://185.178.46.111/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit1.create(RegistrationAPI.class);


    }


    public RegistrationAPI auths(){
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://185.178.46.111/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit2.create(RegistrationAPI.class);


    }

}
