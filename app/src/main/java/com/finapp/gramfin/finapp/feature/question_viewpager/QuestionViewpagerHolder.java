package com.finapp.gramfin.finapp.feature.question_viewpager;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.question_model.data_reqord.AnswerRecordRestModel;
import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;
import com.finapp.gramfin.finapp.service.FragmentRouter;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class QuestionViewpagerHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title_number_of_chapter) public TextView titleNumberOfChapter;
    @BindView(R.id.title_chapter_name) public TextView titleChapterName;
    @BindView(R.id.title_topic_name) public TextView titleTopicName;
    @BindView(R.id.text_question) public TextView textQuestion;
    @BindView(R.id.button_skip) public Button buttonSkip;

    @BindViews({R.id.card_answer_choice_1, R.id.card_answer_choice_2, R.id.card_answer_choice_3, R.id.card_answer_choice_4})
    List<CardView> listChoicesCard;
    @BindViews({R.id.answer_choice_1, R.id.answer_choice_2, R.id.answer_choice_3, R.id.answer_choice_4})
    List<TextView> listChoices;
    @BindViews({R.id.answer_checkbox_1, R.id.answer_checkbox_2, R.id.answer_checkbox_3, R.id.answer_checkbox_4})
    List<CheckBox> listChoicesCheckboxes;

    private ModelQuestion modelQuestion;
    private int id;
    private QuestionViewpagerAdapter.Listener listener;

    private QuestionViewpagerHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        for (final CardView view:listChoicesCard) {
            view.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onFeedClick(id, listChoicesCard.indexOf(view));
                    initViews(modelQuestion);
                }
            });
            view.setVisibility(View.GONE);
        }

        for (final CheckBox view:listChoicesCheckboxes) {
            view.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onFeedClick(id, listChoicesCheckboxes.indexOf(view));
                    initViews(modelQuestion);
                }
            });
            view.setVisibility(View.GONE);
        }

        buttonSkip.setOnClickListener(v -> {
            //gotoNextPage()
            FragmentRouter.getInstance().notImplementedToast();
        });

    }

    @SuppressLint("SetTextI18n")
    void bind(ModelQuestion modelQuestion, QuestionViewpagerAdapter.Listener listener, int id) {
        this.listener = listener;
        this.modelQuestion = modelQuestion;
        this.id = id;

        titleNumberOfChapter.setText(new StringBuilder(1).append(modelQuestion.getChapterId()));
        titleChapterName.setText(modelQuestion.getChapterName());
        titleTopicName.setText(modelQuestion.getTopicName());

        initViews(modelQuestion);
    }

    private void initViews(ModelQuestion modelQuestion) {
        textQuestion.setText(modelQuestion.getCaption());

        int i = 0;
        int choice = modelQuestion.getUserChoice();

        for (AnswerRecordRestModel answer:modelQuestion.getAnswers()) {
            int background_res = R.drawable.element_background_answer_cardview;
            boolean checked = false;

            if (choice == i) {
                checked = true;

                if (answer.is_correct == 1) { background_res = R.drawable.element_background_answer_cardview_true; }
                else { background_res = R.drawable.element_background_answer_cardview_false; }
            }

            TextView view = listChoices.get(i);
            view.setText(answer.content);

            CheckBox checkBox = listChoicesCheckboxes.get(i);
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setChecked(checked);

            CardView cardView = listChoicesCard.get(i++);
            cardView.setVisibility(View.VISIBLE);
            cardView.setBackgroundResource(background_res);
        }
    }

    static QuestionViewpagerHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new QuestionViewpagerHolder(inflater.inflate(R.layout.test_question_fragment, parent, false));
    }
}