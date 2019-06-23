package com.finapp.gramfin.finapp.feature.settings.model;

public class SettingsModel {

    private boolean resetIsChecked = false;
    private String full_name;
    private String email;
    private String password;

    public SettingsModel(String full_name, String email, String password) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
    }

    public boolean isResetIsChecked() { return resetIsChecked; }
    public void setResetIsChecked(boolean resetIsChecked) { this.resetIsChecked = resetIsChecked; }

    public String getFull_name() { return full_name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setFull_name(String full_name) { this.full_name = full_name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
