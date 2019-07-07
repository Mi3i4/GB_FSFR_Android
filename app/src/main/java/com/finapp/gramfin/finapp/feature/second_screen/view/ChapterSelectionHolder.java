package com.finapp.gramfin.finapp.feature.second_screen.view;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;

import butterknife.BindView;
import butterknife.ButterKnife;

class ChapterSelectionHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.number_of_chapter) public TextView numberOfChapter;
    @BindView(R.id.chapter_name) public TextView nameChapter;
    @BindView(R.id.title_topic_name) public TextView numberOfQuetions;
    @BindView(R.id.i_know) public TextView textIknow;
    @BindView(R.id.i_dont_know) public TextView textIdontKnow;

    private ModelChapter modelChapter;
    private int id;
    private ChapterSelectionAdapter.Listener listener;

    private ChapterSelectionHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onFeedClick(id);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    void bind(ModelChapter modelChapter, ChapterSelectionAdapter.Listener listener, int id) {
        this.listener = listener;
        this.modelChapter = modelChapter;
        this.id = id;
        numberOfChapter.setText(Integer.toString(1 + id) );
        nameChapter.setText(modelChapter.getChapter());
        numberOfQuetions.setText("Всего вопросов: " + modelChapter.getNumberOfQuetions());
        textIknow.setText("Знаю: " + modelChapter.getItemIKnow());
        textIdontKnow.setText("Не знаю: " + modelChapter.getItemIdontKnow());

    }

    static ChapterSelectionHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new ChapterSelectionHolder(inflater.inflate(R.layout.item_chapter_selection, parent, false));
    }
}
