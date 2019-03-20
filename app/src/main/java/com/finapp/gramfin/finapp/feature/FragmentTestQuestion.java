package com.finapp.gramfin.finapp.feature;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.finapp.gramfin.finapp.R;

public class FragmentTestQuestion extends Fragment implements View.OnClickListener {
    TextView answer_choice_1;
    TextView answer_choice_2;
    TextView answer_choice_3;
    TextView answer_choice_4;
    TextView findError;
    TextView viewComments;
    ImageButton buttonExpandMore;

    private void initViews() {

        answer_choice_1 = getView().findViewById(R.id.answer_choice_1);
        answer_choice_2 = getView().findViewById(R.id.answer_choice_2);
        answer_choice_3 = getView().findViewById(R.id.answer_choice_3);
        answer_choice_4 = getView().findViewById(R.id.answer_choice_4);
        findError = getView().findViewById(R.id.findError);
        viewComments = getView().findViewById(R.id.view_comments);
        buttonExpandMore = getView().findViewById(R.id.button_expand_more);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.test_question_fragment, container, false);

        return inflatedView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        setOnClick();
        getActivity().setTitle("Тренировка");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.answer_choice_1:
                checkResponse(1, answer_choice_1);
                answer_choice_1.setElevation(2);
                break;
            case R.id.answer_choice_2:
                checkResponse(2, answer_choice_2);
                answer_choice_2.setElevation(2);
                break;
            case R.id.answer_choice_3:
                checkResponse(3, answer_choice_3);
                answer_choice_3.setElevation(2);
                break;
            case R.id.answer_choice_4:
                checkResponse(4, answer_choice_4);
                answer_choice_4.setElevation(2);
                break;
            default:
                Toast.makeText(getActivity(), "Функционал еще не готов...", Toast.LENGTH_SHORT).show();

        }
    }

    private void setOnClick() {
        answer_choice_1.setOnClickListener(this);
        answer_choice_2.setOnClickListener(this);
        answer_choice_3.setOnClickListener(this);
        answer_choice_4.setOnClickListener(this);
        findError.setOnClickListener(this);
        viewComments.setOnClickListener(this);
        buttonExpandMore.setOnClickListener(this);
    }

    // условная реализация проверки правильности ответа на вопрос, для проверки работы экрана 3(очень условная)
    private void checkResponse(int e, View view) {
        int correctAnswer = 4;
        if (e == correctAnswer) {

            view.setBackgroundResource(R.color.colorLightGreen);
        } else {
            view.setBackgroundResource(R.color.colorLightRed);
        }
        ;
    }
}
