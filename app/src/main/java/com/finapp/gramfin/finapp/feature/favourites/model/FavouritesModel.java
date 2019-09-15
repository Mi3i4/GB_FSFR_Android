package com.finapp.gramfin.finapp.feature.favourites.model;

import android.view.View;

import androidx.annotation.Nullable;

public class FavouritesModel {
    @Nullable private int bin_image;
    final String chapter_text;
    final String question_text;
    final View.OnClickListener listener;

    public FavouritesModel(String chapter_text, String question_text, View.OnClickListener listener) {
        this.chapter_text = chapter_text;
        this.question_text = question_text;
        this.listener = listener;
    }

    public int getBin_image() { return bin_image; }
    public void setBin_image(int bin_image) { this.bin_image = bin_image; }

    public String getChapterText() { return chapter_text; }
    public String getQuestionText() { return question_text; }

    public View.OnClickListener getListener() { return listener; }
}
