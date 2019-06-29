package com.finapp.gramfin.finapp.feature.main_menu_fragment;

import androidx.lifecycle.ViewModelProviders;

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
import com.finapp.gramfin.finapp.feature.main_menu_fragment.model.ModelMainMenuItem;

public class MainMenuFragment extends Fragment {

    private MainMenuViewModel viewModel;

    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_menu_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.main_menu_title);

        viewModel = ViewModelProviders.of(this).get(MainMenuViewModel.class);
        viewModel.setupModel();

        ListView listView = getView().findViewById(R.id.lvMainMenu);
        ArrayAdapter<ModelMainMenuItem> adapter = new MainMenuAdapter(getActivity());
        listView.setAdapter(adapter);

    }

    private class MainMenuAdapter extends ArrayAdapter<ModelMainMenuItem> {

        public MainMenuAdapter(@NonNull Context context) {
            super(context, R.layout.main_menu_item, viewModel.getListMainMenu());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ModelMainMenuItem mainMenuItem = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.main_menu_item, null);
            }
            ((ImageView) convertView.findViewById(R.id.main_menu_btn_img))
                    .setImageResource(mainMenuItem.getImage());
            ((TextView) convertView.findViewById(R.id.main_menu_btn_title))
                    .setText(mainMenuItem.getTitle());

            convertView.setOnClickListener(mainMenuItem.getListener());

            return convertView;
        }
    }
}
