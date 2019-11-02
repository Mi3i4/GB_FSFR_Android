package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.RegistrationAPI;
import com.finapp.gramfin.finapp.api.auth_model.User;
import com.finapp.gramfin.finapp.api.auth_model.UserToSend;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthPresenter {

    private Context context;
    private SharedPreferences sharedPreferences;

    public AuthPresenter(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);

    }


    public RegistrationAPI apiService() {
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://167.71.64.44/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit1.create(RegistrationAPI.class);


    }

    public UserToSend getUser(String email, String password)
    {
        return new UserToSend(new User(email, password));

    }


    public void notImplemented()
    {
        Toast.makeText(context, context.getString(R.string.under_construction), Toast.LENGTH_SHORT).show();

    }

    public void saveData(String email, String password, int id, String token)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putString("token", token);
        editor.putInt("id", id);
        editor.apply();

    }

    public void wrongData()
    {
        Toast.makeText(context, context.getString(R.string.wrongData), Toast.LENGTH_LONG).show();

    }


    }


