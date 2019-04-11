package com.finapp.gramfin.finapp.feature.second_screen.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;

import java.util.List;

public class ChapterSelectionAdapter extends RecyclerView.Adapter<ChapterSelectionHolder> {

    private List<ModelChapter> modelChapterList;
    private Listener listener;


    ChapterSelectionAdapter(Listener listener, List<ModelChapter> modelChapterList) {
        super();
        this.listener = listener;
        this.modelChapterList = modelChapterList;
    }

    @NonNull
    @Override
    public ChapterSelectionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return ChapterSelectionHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterSelectionHolder secondScreenHolder, int id) {
        secondScreenHolder.bind(modelChapterList.get(id), listener, id);
    }

    @Override
    public int getItemCount() {
        return modelChapterList.size();
    }

    public interface Listener {
        void onFeedClick(int id);
    }

}
