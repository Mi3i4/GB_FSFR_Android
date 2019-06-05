package com.finapp.gramfin.finapp.feature.statistics.wrong_answers.model;

import android.view.View;

public class WrongAnswersModel {

    final String chapter_text;
    final String question_text;
    final View.OnClickListener listener;

    public WrongAnswersModel(String chapter_text, String question_text, View.OnClickListener listener) {
        this.chapter_text = chapter_text;
        this.question_text = question_text;
        this.listener = listener;
    }

    public String getChapterText() { return chapter_text; }
    public String getQuestionText() { return question_text; }

    public View.OnClickListener getListener() { return listener; }
}
