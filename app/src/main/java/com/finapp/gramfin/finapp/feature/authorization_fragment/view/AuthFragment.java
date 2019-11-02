package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.finapp.gramfin.finapp.MainActivity;
import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.auth_model.AuthModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AuthFragment extends Fragment {

    private OnFragmentInteractionListener mListener;


    private AuthPresenter authPresenter;
    @BindView(R.id.emailtv)
    TextView email;

    @BindView(R.id.passtv)
    TextView password;

    @BindView(R.id.email)
    EditText emailet;

    @BindView(R.id.password)
    EditText passwordet;


    @OnClick(R.id.forgetPasswordtv)
    public void forgetPassword()
    {
        authPresenter.notImplemented();

    }


    @OnClick(R.id.guestAccess)
    public void guestClick()
    {
        authPresenter.notImplemented();

    }

    @OnClick(R.id.loginViaGoogle)
    public void loginGoogle() {
        authPresenter.notImplemented();
    }

    @OnClick(R.id.authorizebutton)
    public void authorize() {
        String email = emailet.getText().toString();
        String password = passwordet.getText().toString();
        authPresenter.apiService().authme(authPresenter.getUser(email, password)).enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                if (response.code() == 200) {
                    AuthModel authModel = response.body();
                    authPresenter.saveData(email, password, authModel.user.id, authModel.user.token);
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    authPresenter.wrongData();

                }
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {

            }
        });

    }

    @OnClick(R.id.loginViaFB)
    public void loginFB() {

      authPresenter.notImplemented();


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
        authPresenter = new AuthPresenter(getContext());
        ButterKnife.bind(this, root);


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
