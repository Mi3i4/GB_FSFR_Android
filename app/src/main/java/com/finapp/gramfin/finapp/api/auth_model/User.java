package com.finapp.gramfin.finapp.api.auth_model;

public class User {

    public String password;
    public String email;

    public User(String email, String password) {

        this.email = email;
        this.password = password;

    }


}
