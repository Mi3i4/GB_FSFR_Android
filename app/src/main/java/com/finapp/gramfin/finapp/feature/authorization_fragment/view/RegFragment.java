package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.question_model.PostModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegFragment extends Fragment {

    Button regBut;
    RegPresenter regPresenter;
    EditText name;
    EditText email;
    EditText password;
    private OnFragmentInteractionListener mListener;

    public RegFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        regPresenter = new RegPresenter();
        View root = inflater.inflate(R.layout.fragment_reg, container, false);
        name = root.findViewById(R.id.yournameet);
        email=root.findViewById(R.id.emailet);
        password=root.findViewById(R.id.passwordet);
        regBut=root.findViewById(R.id.regbutton);
        regBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regPresenter.regme().regme(name.getText().toString(),email.getText().toString(), password.getText().toString()).enqueue(new Callback<PostModel>() {
                    @Override
                    public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                        Log.d("a","b");
                    }

                    @Override
                    public void onFailure(Call<PostModel> call, Throwable t) {
                        Log.d("a","b");
                    }
                });
            }
        });
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
