package com.finapp.gramfin.finapp.feature.question_viewpager;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.question_model.data_reqord.AnswerRecordRestModel;
import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class QuestionViewpagerHolder extends RecyclerView.ViewHolder {
    private View root;

    private TextView textQuestion;
    private TextView answer_choice_1;
    private TextView answer_choice_2;
    private TextView answer_choice_3;
    private TextView answer_choice_4;
    private TextView findError;
    private TextView viewComments;
    private ImageButton buttonExpandMore;
    private ModelQuestion modelQuestion;
    private List<TextView> views;
    private int id;
    private QuestionViewpagerAdapter.Listener listener;

    public QuestionViewpagerHolder(@NonNull View itemView) {
        super(itemView);

        root = itemView;
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onFeedClick(v);
                }
            }
        });

        textQuestion = root.findViewById(R.id.text_question);

        answer_choice_1 = root.findViewById(R.id.answer_choice_1);
        answer_choice_2 = root.findViewById(R.id.answer_choice_2);
        answer_choice_3 = root.findViewById(R.id.answer_choice_3);
        answer_choice_4 = root.findViewById(R.id.answer_choice_4);
        views = Arrays.asList(answer_choice_1, answer_choice_2, answer_choice_3, answer_choice_4);

        findError = root.findViewById(R.id.findError);
        viewComments = root.findViewById(R.id.view_comments);
        buttonExpandMore = root.findViewById(R.id.button_expand_more);
    }

    @SuppressLint("SetTextI18n")
    void bind(ModelQuestion modelQuestion, QuestionViewpagerAdapter.Listener listener, int id) {
        this.listener = listener;
        this.modelQuestion = modelQuestion;
        this.id = id;

        textQuestion.setText(modelQuestion.getCaption());

        int i = 0;
        for (AnswerRecordRestModel answer:modelQuestion.getAnswers()) {
            views.get(i++).setText(answer.content);
        }
    }
    static QuestionViewpagerHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new QuestionViewpagerHolder(inflater.inflate(R.layout.test_question_fragment, parent, false));
    }
}