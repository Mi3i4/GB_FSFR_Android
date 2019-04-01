package com.finapp.gramfin.finapp.feature.second_screen.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;
import com.finapp.gramfin.finapp.feature.second_screen.presenter.IFragmentChooseChapter;
import com.finapp.gramfin.finapp.feature.second_screen.presenter.PresenterChapterSelection;

import java.util.List;
import java.util.Objects;

public class FragmentChapterSeliction extends Fragment implements IFragmentChooseChapter, ChapterSelectionAdapter.Listener {

    PresenterChapterSelection presenterSecondScreen;

    private RecyclerView recViewChapters;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_chapter_selection, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        presenterSecondScreen = new PresenterChapterSelection(this);
    }

    private void initViews(View view) {
        recViewChapters = view.findViewById(R.id.recViewChapter);
    }


    @Override
    public void setChapters(List<ModelChapter> listChapters) {

        recViewChapters.setLayoutManager(new LinearLayoutManager(getActivity()));
        recViewChapters.setHasFixedSize(false);
        ChapterSelectionAdapter secondScreenAdapter = new ChapterSelectionAdapter(this, listChapters);
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
