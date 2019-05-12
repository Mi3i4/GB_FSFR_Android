package com.finapp.gramfin.finapp.feature;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;

public class FragmentTestQuestion extends Fragment implements View.OnClickListener {
    TextView answer_choice_1;
    TextView answer_choice_2;
    TextView answer_choice_3;
    TextView answer_choice_4;

    Button buttonSkip;

    private void initViews() {

        answer_choice_1 = getView().findViewById(R.id.answer_choice_1);
        answer_choice_2 = getView().findViewById(R.id.answer_choice_2);
        answer_choice_3 = getView().findViewById(R.id.answer_choice_3);
        answer_choice_4 = getView().findViewById(R.id.answer_choice_4);

        buttonSkip = getView().findViewById(R.id.button_skip);
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
                FragmentRouter.getInstance().notImplementedToast();

        }
    }

    private void setOnClick() {
        answer_choice_1.setOnClickListener(this);
        answer_choice_2.setOnClickListener(this);
        answer_choice_3.setOnClickListener(this);
        answer_choice_4.setOnClickListener(this);
        buttonSkip.setOnClickListener(this);
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
