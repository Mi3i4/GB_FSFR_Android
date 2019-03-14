package com.finapp.gramfin.finapp.feature.second_screen.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;
import com.finapp.gramfin.finapp.feature.second_screen.presenter.IFragmentSetChapters;
import com.finapp.gramfin.finapp.feature.second_screen.presenter.PresenterSecondScreen;

import java.util.List;

public class FragmentSecondScreen extends Fragment implements IFragmentSetChapters {

    PresenterSecondScreen presenterSecondScreen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_second_screen, container, false);
        presenterSecondScreen = new PresenterSecondScreen(this);
        return view;

    }


    @Override
    public void setChapters(List<ModelChapter> listChapters) {

    }
}
