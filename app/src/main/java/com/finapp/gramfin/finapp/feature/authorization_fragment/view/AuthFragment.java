package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.finapp.gramfin.finapp.MainActivity;
import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.question_model.AuthModel;
import com.finapp.gramfin.finapp.api.question_model.Authorize;
import com.finapp.gramfin.finapp.api.question_model.googleModel;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AuthFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    Button Fblogin;
    AuthPresenter authPresenter;
    @BindView(R.id.emailtv)
    TextView email;

    @BindView(R.id.passtv)
    TextView password;

    @BindView(R.id.email)
    EditText emailet;

    @BindView(R.id.password)
    EditText passwordet;

     @OnClick(R.id.loginViaGoogle)
     public void loginGoogle()
     {
        authPresenter.loginViaGoogle().loginViaGoogle().enqueue(new Callback<googleModel>() {
            @Override
            public void onResponse(Call<googleModel> call, Response<googleModel> response) {
                Log.d("a", "b");
            }

            @Override
            public void onFailure(Call<googleModel> call, Throwable t) {
                Log.d("a", "b");
            }
        });

    }

    @OnClick(R.id.authorizebutton)
            public void authorize()
    {
        Log.d("a","b");
        authPresenter.authme().authme(emailet.getText().toString(), passwordet.getText().toString()).enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                Log.d("a", "b");
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {
                Log.d("a", "b");
            }
        });

    }

    @OnClick(R.id.loginViaFB)
            public void loginFB()
    {
        //Intent intent = new Intent(getActivity(), MainActivity.class);
       // startActivity(intent);
            authPresenter.auths().auths("as").enqueue(new Callback<Authorize>() {
                @Override
                public void onResponse(Call<Authorize> call, Response<Authorize> response) {
                    Log.d("a"," b");
                }

                @Override
                public void onFailure(Call<Authorize> call, Throwable t) {
                    Log.d("a","b");
                }
            });


    }



    public AuthFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AuthFragment newInstance(String param1, String param2) {
        AuthFragment fragment = new AuthFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_auth, container, false);
        authPresenter = new AuthPresenter();
        ButterKnife.bind(this,root);


        return root;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
