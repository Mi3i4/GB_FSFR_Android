package com.finapp.gramfin.finapp.feature.settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.BR;
import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.settings.model.SettingsModel;
import com.finapp.gramfin.finapp.service.FragmentRouter;

public class SettingsViewModel extends ViewModel implements Observable {
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

    @Nullable private SettingsModel settingsModel;
    @Nullable private AlertDialog alertDialog;

    void setupModel(AlertDialog alertDialog) {
        this.alertDialog = alertDialog;

        //TODO implement settings receiving
        this.settingsModel = new SettingsModel(FragmentRouter.getInstance().getString(R.string.full_name_holder),
                FragmentRouter.getInstance().getString(R.string.email_holder),
                FragmentRouter.getInstance().getString(R.string.password_holder));
    }

    @Nullable SettingsModel getSettingsModel() { return  settingsModel; }
    @Bindable public String getFullName() { return settingsModel.getFull_name(); }
    @Bindable public String getEmail() { return settingsModel.getEmail(); }
    @Bindable public String getPassword() { return FragmentRouter.getInstance().getString(R.string.password_holder); }

    public void setResetState(boolean resetIsChecked) { settingsModel.setResetIsChecked(resetIsChecked); }

    void saveSettings(String full_name_new, String email_new, String password_new) {
        //TODO save settings
        if (!full_name_new.isEmpty()) { settingsModel.setFull_name(full_name_new); }
        if (email_new.matches("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$")) { settingsModel.setEmail(email_new); }
        if (!password_new.isEmpty()) { settingsModel.setPassword(password_new); }

        if (settingsModel.isResetIsChecked()) { if (alertDialog != null) alertDialog.show(); }
        else { FragmentRouter.getInstance().notImplementedToast(); }

        registry.notifyChange(this, BR._all);
    }

    public void resetStatistics() {
        //TODO implement resetStatistics action
        if (alertDialog != null) { alertDialog.dismiss(); }
        FragmentRouter.getInstance().notImplementedToast();
    }

    public void cancelResetStatistics() {
        //TODO implement cancel resetStatistics action
        if (alertDialog != null) { alertDialog.cancel(); }
        FragmentRouter.getInstance().notImplementedToast();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.remove(callback);
    }
}
