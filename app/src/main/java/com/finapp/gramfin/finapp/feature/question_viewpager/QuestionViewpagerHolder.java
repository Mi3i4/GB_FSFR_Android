package com.finapp.gramfin.finapp.feature.question_viewpager;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.question_model.data_reqord.AnswerRecordRestModel;
import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;

import java.util.Arrays;
import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionViewpagerHolder extends RecyclerView.ViewHolder {
    private View root;

    private TextView textQuestion;
    private TextView answer_choice_1;
    private TextView answer_choice_2;
    private TextView answer_choice_3;
    private TextView answer_choice_4;
    private CardView card_answer_choice_1;
    private CardView card_answer_choice_2;
    private CardView card_answer_choice_3;
    private CardView card_answer_choice_4;

    private List<TextView> listChoices;
    private List<CardView> listChoicesCard;

    private Button buttonSkip;
    private ModelQuestion modelQuestion;
    private List<TextView> views;
    private int id;
    private QuestionViewpagerAdapter.Listener listener;

    public QuestionViewpagerHolder(@NonNull View itemView) {
        super(itemView);

        root = itemView;
        textQuestion = root.findViewById(R.id.text_question);

        answer_choice_1 = root.findViewById(R.id.answer_choice_1);
        answer_choice_2 = root.findViewById(R.id.answer_choice_2);
        answer_choice_3 = root.findViewById(R.id.answer_choice_3);
        answer_choice_4 = root.findViewById(R.id.answer_choice_4);

        card_answer_choice_1 = root.findViewById(R.id.card_answer_choice_1);
        card_answer_choice_2 = root.findViewById(R.id.card_answer_choice_2);
        card_answer_choice_3 = root.findViewById(R.id.card_answer_choice_3);
        card_answer_choice_4 = root.findViewById(R.id.card_answer_choice_4);

        buttonSkip = root.findViewById(R.id.button_skip);
        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gotoNextPage()
                FragmentRouter.getInstance().notImplementedToast();

            }
        });

        listChoicesCard = Arrays.asList(card_answer_choice_1, card_answer_choice_2, card_answer_choice_3, card_answer_choice_4);
        listChoices = Arrays.asList(answer_choice_1, answer_choice_2, answer_choice_3, answer_choice_4);
        for (CardView view : listChoicesCard) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {

                        switch (v.getId()) {
                            case R.id.card_answer_choice_1:
                                listener.onFeedClick(0, id, card_answer_choice_1);
                                break;
                            case R.id.card_answer_choice_2:
                                listener.onFeedClick(1, id, card_answer_choice_2);
                                break;
                            case R.id.card_answer_choice_3:
                                listener.onFeedClick(2, id, card_answer_choice_3);
                                break;
                            case R.id.card_answer_choice_4:
                                listener.onFeedClick(3, id, card_answer_choice_4);
                                break;
                            default:
                                FragmentRouter.getInstance().notImplementedToast();
                        }
                    }
                }
            });
            // view.setVisibility(View.GONE);
        }


    }

    @SuppressLint("SetTextI18n")
    void bind(ModelQuestion modelQuestion, QuestionViewpagerAdapter.Listener listener, int id) {
        this.listener = listener;
        this.id = id;

        textQuestion.setText(modelQuestion.getCaption());

        int i = 0;
        for (AnswerRecordRestModel answer : modelQuestion.getAnswers()) {

            TextView view = listChoices.get(i++);
            view.setText(answer.content);
            //  view.setVisibility(View.VISIBLE);
            //view.setBackgroundResource(R.color.colorLightGray);
        }
        for (CardView cardView:listChoicesCard){
            cardView.setBackgroundResource(R.color.colorWhite);

        }
    }

    static QuestionViewpagerHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new QuestionViewpagerHolder(inflater.inflate(R.layout.test_question_fragment, parent, false));
    }

}


