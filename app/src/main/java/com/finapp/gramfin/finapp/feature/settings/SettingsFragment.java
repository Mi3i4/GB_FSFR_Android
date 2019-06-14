package com.finapp.gramfin.finapp.feature.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends Fragment {

    @BindView(R.id.settings_reset_switch) Switch resetSwitch;
    @BindView(R.id.settings_full_name) TextView tvFullName;
    @BindView(R.id.settings_email) TextView tvEmail;
    @BindView(R.id.settings_password) TextView tvPassword;
    @BindView(R.id.settings_new_name) EditText etNewName;
    @BindView(R.id.settings_new_email) EditText etNewEmail;
    @BindView(R.id.settings_new_password) EditText etNewPassword;

    private SettingsViewModel viewModel;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        viewModel.setupModel(createAlertDialog());

        resetSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.setResetState(isChecked));

        tvFullName.setText(viewModel.getFullName());
        tvEmail.setText(viewModel.getEmail());
        tvPassword.setText(viewModel.getPassword());
    }

    @OnClick(R.id.settings_btn_save)
    public void onClick(View v) {
        viewModel.saveSettings(tvFullName.getText().toString(), tvEmail.getText().toString(), tvPassword.getText().toString());
    }

    public AlertDialog createAlertDialog() {
        DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    viewModel.resetStatistics();
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    viewModel.cancelResetStatistics();
                    break;
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder.setTitle("Сбросить статистику?")
                .setMessage("Данное действие приведет к удалению всех данных статистики.")
                .setPositiveButton("Да", dialogClickListener)
                .setNegativeButton("Нет", dialogClickListener)
                .create();
    }
}
