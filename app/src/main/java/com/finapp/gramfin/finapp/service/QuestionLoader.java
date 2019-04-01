package com.finapp.gramfin.finapp.service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.finapp.gramfin.finapp.api.QuestionRepo;
import com.finapp.gramfin.finapp.api.question_model.DataRecordRestModel;
import com.finapp.gramfin.finapp.api.question_model.PageRestModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionLoader {

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
                    listener.onComplete(item);
                    return;
                }
            }

            page += 1;
        }

        getPage(page, new OnPageListener() {
            @Override
            public void onComplete(PageRestModel result) {
                searchPage(result.current_page, result);
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
                listener.onComplete(pageFromCash);
                return;
            }
        }

        QuestionRepo.getAPI().loadQuestions(page)
                .enqueue(new Callback<PageRestModel>() {
                    @Override
                    public void onResponse(Call<PageRestModel> call, Response<PageRestModel> response) {
                        if (response.isSuccessful()) {
                            pagesCash.add(response.body());
                            listener.onComplete(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<PageRestModel> call, Throwable t) {
                        requestDone = true;
                    }
                });
    }

    public interface OnRequestListener {
        void onComplete(DataRecordRestModel result);
    }

    public interface OnPageListener {
        void onComplete(PageRestModel result);
    }
}
