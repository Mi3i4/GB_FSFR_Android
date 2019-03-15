package com.finapp.gramfin.finapp.feature.second_screen.view;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;
import com.finapp.gramfin.finapp.feature.second_screen.presenter.IFragmentSetChapters;
import com.finapp.gramfin.finapp.feature.second_screen.presenter.PresenterSecondScreen;

import java.util.List;
import java.util.Objects;

public class FragmentSecondScreen extends Fragment implements IFragmentSetChapters, SecondScreenAdapter.Listener {

    PresenterSecondScreen presenterSecondScreen;

    private RecyclerView recViewChapters;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_second_screen, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        presenterSecondScreen = new PresenterSecondScreen(this);
    }

    private void initViews(View view) {
        recViewChapters = view.findViewById(R.id.recViewChapter);
    }


    @Override
    public void setChapters(List<ModelChapter> listChapters) {

        recViewChapters.setLayoutManager(new LinearLayoutManager(getActivity()));
        recViewChapters.setHasFixedSize(false);
        SecondScreenAdapter secondScreenAdapter = new SecondScreenAdapter(this, listChapters);
        recViewChapters.setAdapter(secondScreenAdapter);

    }

    @Override
    public void setToast(String error) {
        Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFeedClick(int id) {
        presenterSecondScreen.callBackIdModelChapters(id);

    }
}
