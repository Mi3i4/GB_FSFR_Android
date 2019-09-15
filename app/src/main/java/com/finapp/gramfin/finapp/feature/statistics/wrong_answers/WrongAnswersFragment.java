package com.finapp.gramfin.finapp.feature.statistics.wrong_answers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.statistics.wrong_answers.model.WrongAnswersModel;

public class WrongAnswersFragment extends Fragment {

    private WrongAnswersViewModel viewModel;

    public static WrongAnswersFragment newInstance() {
        return new WrongAnswersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wrong_answers_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.wrong_answers_title);

        viewModel = new ViewModelProvider(this).get(WrongAnswersViewModel.class);
        viewModel.setupModel();

        ListView listView = getView().findViewById(R.id.lvWrongAnswers);
        ArrayAdapter<WrongAnswersModel> adapter = new WrongAnswersAdapter(getActivity());
        listView.setAdapter(adapter);
    }

    private class WrongAnswersAdapter extends ArrayAdapter<WrongAnswersModel> {

        public WrongAnswersAdapter(@NonNull Context context) {
            super(context, R.layout.wrong_answers_item, viewModel.getWrongAnswersModelArrayList());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final WrongAnswersModel item = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.wrong_answers_item, null);
            }
            ((TextView) convertView.findViewById(R.id.wrong_answers_chapter_text))
                    .setText(item.getChapterText());
            ((TextView) convertView.findViewById(R.id.wrong_answers_question_text))
                    .setText(item.getQuestionText());

            convertView.setOnClickListener(item.getListener());

            return convertView;
        }
    }

}
