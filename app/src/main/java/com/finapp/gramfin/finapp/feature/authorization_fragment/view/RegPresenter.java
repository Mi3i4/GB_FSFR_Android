package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import com.finapp.gramfin.finapp.api.RegistrationAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegPresenter {


    public RegistrationAPI regme() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://185.178.46.111/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RegistrationAPI.class);
    }


}





