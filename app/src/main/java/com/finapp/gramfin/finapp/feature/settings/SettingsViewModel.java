package com.finapp.gramfin.finapp.feature.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.settings.model.SettingsModel;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;

public class SettingsViewModel extends ViewModel {
    private SettingsModel settingsModel;
    private AlertDialog alertDialog;

    public void setupModel(AlertDialog alertDialog) {
        this.alertDialog = alertDialog;

        //TODO implement settings receiving
        this.settingsModel = new SettingsModel(FragmentRouter.getInstance().getString(R.string.full_name_holder),
                FragmentRouter.getInstance().getString(R.string.email_holder),
                FragmentRouter.getInstance().getString(R.string.password_holder));
    }

    public String getFullName() { return settingsModel.getFull_name(); }
    public String getEmail() { return settingsModel.getEmail(); }
    public String getPassword() { return settingsModel.getPassword(); }

    public void setResetState(boolean resetIsChecked) { settingsModel.setResetIsChecked(resetIsChecked); }

    public void saveSettings(String full_name_new, String email_new, String password_new) {
        //TODO save settings
        if (!full_name_new.isEmpty()) { settingsModel.setFull_name(full_name_new); }
        if (email_new.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) { settingsModel.setEmail(email_new); }
        if (!password_new.isEmpty()) { settingsModel.setPassword(password_new); }

        if (settingsModel.isResetIsChecked()) { alertDialog.show(); }
        else {FragmentRouter.getInstance().notImplementedToast(); }
    }

    public void resetStatistics() {
        //TODO implement resetStatistics action
        FragmentRouter.getInstance().notImplementedToast();
    }

    public void cancelResetStatistics() {
        //TODO implement cancel resetStatistics action
        FragmentRouter.getInstance().notImplementedToast();
    }
}
