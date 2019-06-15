package com.finapp.gramfin.finapp.feature.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        viewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        viewModel.setupModel(createAlertDialog(container));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        resetSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.setResetState(isChecked));

        tvFullName.setText(viewModel.getFullName());
        tvEmail.setText(viewModel.getEmail());
        tvPassword.setText(viewModel.getPassword());
    }

    @OnClick(R.id.settings_btn_save)
    void onClick(View v) {
        viewModel.saveSettings(tvFullName.getText().toString(), tvEmail.getText().toString(), tvPassword.getText().toString());
    }

    @Nullable
    private AlertDialog createAlertDialog(ViewGroup container) {
        Context context = getContext();
        if (context != null) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.settings_alert, container, false);
            view.findViewById(R.id.settings_alert_positive_answer).setOnClickListener(v -> viewModel.resetStatistics());
            view.findViewById(R.id.settings_alert_negative_answer).setOnClickListener(v -> viewModel.cancelResetStatistics());

            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.SettingsAlertDialogTheme);
            return builder.setView(view)
                    .create();
        } else return null;
    }
}