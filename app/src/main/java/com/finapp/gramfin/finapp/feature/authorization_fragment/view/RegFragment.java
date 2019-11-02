package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.finapp.gramfin.finapp.MainActivity;
import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.auth_model.RegModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegFragment extends Fragment {

    private Button regBut;
    private  RegPresenter regPresenter;
    private EditText name;
    private EditText email;
    private  EditText password;

    public RegFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        regPresenter = new RegPresenter(getContext());
        View root = inflater.inflate(R.layout.fragment_reg, container, false);
        name = root.findViewById(R.id.yournameet);
        email=root.findViewById(R.id.emailet);
        password=root.findViewById(R.id.passwordet);
        regBut=root.findViewById(R.id.regbutton);
        regBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regPresenter.apiservice().regme(regPresenter.getUser(email.getText().toString(), password.getText().toString())).enqueue(new Callback<RegModel>() {
                    @Override
                    public void onResponse(Call<RegModel> call, Response<RegModel> response) {
                        if (response.code() == 200) {
                            RegModel regModel = response.body();
                            regPresenter.saveData(regModel.user.email, password.getText().toString(), regModel.user.id, regModel.user.token);
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            regPresenter.wrongData();

                        }
                    }

                    @Override
                    public void onFailure(Call<RegModel> call, Throwable t) {

                    }
                });
            }
        });
        return root;
    }





}
