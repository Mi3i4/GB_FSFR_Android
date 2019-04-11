package com.finapp.gramfin.finapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionRepo {
    private static final String API_URL = "http://92.53.107.185/";

    private static QuestionAPI API;
    private static QuestionRepo instance = null;

    private QuestionRepo() { }

    public static QuestionAPI getAPI() {
        if (instance == null) {
            instance = new QuestionRepo();
            API = createAdapter();
        }
        return API;
    }

    private static QuestionAPI createAdapter() {
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return adapter.create(QuestionAPI.class);
    }
}
