package com.finapp.gramfin.finapp.feature.question_viewpager;

import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class QuestionViewpagerAdapter extends RecyclerView.Adapter<QuestionViewpagerHolder> {

    private List<ModelQuestion> modelQuestions;
    private QuestionViewpagerAdapter.Listener listener;


    QuestionViewpagerAdapter(QuestionViewpagerAdapter.Listener listener, List<ModelQuestion> modelQuestions) {
        super();
        this.listener = listener;
        this.modelQuestions = modelQuestions;
    }

    @NonNull
    @Override
    public QuestionViewpagerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return QuestionViewpagerHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewpagerHolder questionViewpagerHolder, int id) {
        questionViewpagerHolder.bind(modelQuestions.get(id), listener, id);
    }

    @Override
    public int getItemCount() {
        return modelQuestions.size();
    }

    public interface Listener {
        void onFeedClick(int id, int choice);
    }
}
