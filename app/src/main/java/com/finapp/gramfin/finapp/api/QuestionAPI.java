package com.finapp.gramfin.finapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.finapp.gramfin.finapp.api.question_model.PageRestModel;

public interface QuestionAPI {
    @GET("api/question")
    Call<PageRestModel> loadQuestions(@Query("page") int page);
}
