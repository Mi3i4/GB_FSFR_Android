package com.finapp.gramfin.finapp.feature.favourites;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.favourites.model.FavouritesModel;

public class FavouritesFragment extends Fragment {

    private FavouritesViewModel viewModel;

    public static FavouritesFragment newInstance() {
        return new FavouritesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favourites_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.favourites_title);

        viewModel = new ViewModelProvider(this).get(FavouritesViewModel.class);
        viewModel.setupModel();

        ListView listView = getView().findViewById(R.id.lvFavourites);
        ArrayAdapter<FavouritesModel> adapter = new FavouritesAdapter(getActivity());
        listView.setAdapter(adapter);
    }

    private class FavouritesAdapter extends ArrayAdapter<FavouritesModel> {

        public FavouritesAdapter(@NonNull Context context) {
            super(context, R.layout.favourites_item, viewModel.getFavouritesModelArrayList());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final FavouritesModel item = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.favourites_item, null);
            }
            ((TextView) convertView.findViewById(R.id.favourites_chapter_text))
                    .setText(item.getChapterText());
            ((TextView) convertView.findViewById(R.id.favourites_question_text))
                    .setText(item.getQuestionText());
            ((ImageView) convertView.findViewById(R.id.favourites_bin))
                    .setImageResource(item.getBin_image());

            convertView.setOnClickListener(item.getListener());

            return convertView;
        }
    }

}
