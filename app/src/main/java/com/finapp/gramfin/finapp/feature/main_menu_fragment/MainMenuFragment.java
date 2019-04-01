package com.finapp.gramfin.finapp.feature.main_menu_fragment;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.finapp.gramfin.finapp.R;

public class MainMenuFragment extends Fragment implements View.OnClickListener {

    private MainMenuViewModel viewModel;

    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_menu_fragment, container, false);
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

        viewModel = ViewModelProviders.of(this).get(MainMenuViewModel.class);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_start_learning:
                // TODO: Implement кнопка "Изучение" нажата
                Toast.makeText(getActivity(), "Функционал еще не готов...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_start_training:
                viewModel.startTraining();
                break;
            case R.id.btn_start_exam:
                // TODO: Implement кнопка "Экзамен" нажата
                Toast.makeText(getActivity(), "Функционал еще не готов...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
