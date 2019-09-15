package com.finapp.gramfin.finapp.feature.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.databinding.SettingsAlertBinding;
import com.finapp.gramfin.finapp.databinding.SettingsFragmentBinding;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends Fragment {

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

        viewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        if (viewModel.getSettingsModel() == null) {
            viewModel.setupModel(createAlertDialog(container));
        }

        SettingsFragmentBinding.bind(view).setViewModel(viewModel);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.settings_title);
    }

    @OnClick(R.id.settings_btn_save)
    void onClick(View v) {
        viewModel.saveSettings(etNewName.getText().toString(), etNewEmail.getText().toString(), etNewPassword.getText().toString());
    }

    @Nullable
    private AlertDialog createAlertDialog(ViewGroup container) {
        Context context = getContext();
        if (context != null) {
            View view = getLayoutInflater().inflate(R.layout.settings_alert, container, false);
            SettingsAlertBinding.bind(view).setViewModel(viewModel);

            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.SettingsAlertDialogTheme);
            return builder.setView(view)
                    .create();
        } else return null;
    }
}
