package com.finapp.gramfin.finapp.service;

import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.finapp.gramfin.finapp.api.QuestionRepo;
import com.finapp.gramfin.finapp.api.question_model.DataRecordRestModel;
import com.finapp.gramfin.finapp.api.question_model.PageRestModel;

import java.util.ArrayList;

public class QuestionLoader {

    public final static String QUESTION_COMPLETE = "OK";
    public final static String QUESTION_NOT_FOUND = "question not found";
    private static QuestionLoader instance = null;
    private static DataRecordRestModel retrofitDataRecord;
    private static boolean requestDone;
    private int chapter_id, id;
    private OnRequestListener listener;
    private ArrayList<PageRestModel> pagesCash = new ArrayList<>();


    private QuestionLoader() { }

    public static QuestionLoader getInstance() {
        if (instance == null) {
            instance = new QuestionLoader();
        }
        return instance;
    }

    private void searchPage(int page, PageRestModel retrofitCurPage) {
        if (retrofitCurPage != null) {
            for (DataRecordRestModel item: retrofitCurPage.data) {
                if (item.chapters_id == chapter_id && item.id == id) {
                    requestDone = true;
                    listener.onComplete(item, QUESTION_COMPLETE);
                    return;
                }
            }

            if (retrofitCurPage.last_page > 0 && retrofitCurPage.per_page > 0) {
                page = id / retrofitCurPage.per_page + ((id % retrofitCurPage.per_page > 0) ? 1 : 0);
                if (page > retrofitCurPage.last_page) {
                    requestDone = true;
                    listener.onComplete(null, QUESTION_NOT_FOUND);
                    return;
                }
            } else page += 1;
        }

        getPage(page, new OnPageListener() {
            @Override
            public void onComplete(PageRestModel result, String error) {
                if (result != null) searchPage(result.current_page, result);
                else listener.onComplete(null, error);
            }
        });
    }

    public void getDataRecord(int chapter_id, int id, OnRequestListener listener) {
        retrofitDataRecord = null; requestDone = false;
        this.listener = listener;
        this.chapter_id = chapter_id;
        this.id = id;

        searchPage(1, null);
    }

    public void clearCash() {
        pagesCash.clear();
    }

    private void getPage(int page, final OnPageListener listener) {
        for (PageRestModel pageFromCash:pagesCash) {
            if (pageFromCash.current_page == page) {
                listener.onComplete(pageFromCash, "from cash");
                return;
            }
        }

        QuestionRepo.getAPI().loadQuestions(page)
                .enqueue(new Callback<PageRestModel>() {
                    @Override
                    public void onResponse(Call<PageRestModel> call, Response<PageRestModel> response) {
                        if (response.isSuccessful()) {
                            pagesCash.add(response.body());
                            listener.onComplete(response.body(), response.message());
                        } else {
                            requestDone = true;
                            listener.onComplete(null,response.code() + " " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PageRestModel> call, Throwable t) {
                        requestDone = true;
                        listener.onComplete(null, t.toString());
                    }
                });
    }

    public interface OnRequestListener {
        void onComplete(@Nullable DataRecordRestModel result, String error);
    }

    public interface OnPageListener {
        void onComplete(@Nullable PageRestModel result, String error);
    }
}
