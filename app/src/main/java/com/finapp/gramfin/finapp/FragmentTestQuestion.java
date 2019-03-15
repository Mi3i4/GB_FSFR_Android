package com.finapp.gramfin.finapp;

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

public class FragmentTestQuestion extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.test_question_fragment, container, false);


        final TextView textView_1 = inflatedView.findViewById(R.id.answer_choice_1);
        textView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResponse(1, textView_1);
                textView_1.setElevation(2);
            }
        });
        final TextView textView_2 = inflatedView.findViewById(R.id.answer_choice_2);
        textView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResponse(2, textView_2);
                textView_2.setElevation(2);
            }
        });


        final TextView textView_3 = inflatedView.findViewById(R.id.answer_choice_3);
        textView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResponse(3, textView_3);
                textView_3.setElevation(2);
            }
        });
        final TextView textView_4 = inflatedView.findViewById(R.id.answer_choice_4);
        textView_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkResponse(4, textView_4);
                textView_4.setElevation(2);
            }
        });


        TextView findError = inflatedView.findViewById(R.id.findError);
        findError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "функционал еще не готов", Toast.LENGTH_SHORT).show();
            }
        });
        TextView viewComments = inflatedView.findViewById(R.id.view_comments);
        viewComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "функционал еще не готов", Toast.LENGTH_SHORT).show();

            }
        });
        ImageButton buttonExpandMore = inflatedView.findViewById(R.id.button_expand_more);
        buttonExpandMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "функционал еще не готов", Toast.LENGTH_SHORT).show();

            }
        });

        return inflatedView;
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
