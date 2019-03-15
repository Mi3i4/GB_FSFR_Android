package com.finapp.gramfin.finapp.feature.FirstScreen;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.finapp.gramfin.finapp.R;

public class FirstScreen extends Fragment implements View.OnClickListener {

    private FirstScreenViewModel mViewModel;

    public static FirstScreen newInstance() {
        return new FirstScreen();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_screen_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.first_screen_name);

        Button btn_start_learning = getView().findViewById(R.id.btn_start_learning);
        Button btn_start_training = getView().findViewById(R.id.btn_start_training);
        Button btn_start_exam = getView().findViewById(R.id.btn_start_exam);

        btn_start_learning.setOnClickListener(this);
        btn_start_training.setOnClickListener(this);
        btn_start_exam.setOnClickListener(this);

        mViewModel = ViewModelProviders.of(this).get(FirstScreenViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_start_learning:
                // TODO: Implement кнопка "Изучение" нажата
            case R.id.btn_start_training:
                // TODO: Implement кнопка "Тренировка" нажата
            case R.id.btn_start_exam:
                // TODO: Implement кнопка "Экзамен" нажата

                Toast.makeText(getActivity(), "Функционал еще не готов...", Toast.LENGTH_SHORT).show();
        }
    }
}
