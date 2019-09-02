package com.finapp.gramfin.finapp.feature.main_menu_fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Display;
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
    private Point screenSize = new Point();
    private int LOW_SCREEN_HEIGHT = 1280;

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

        viewModel = new ViewModelProvider(this).get(MainMenuViewModel.class);
        viewModel.setupModel();

        ListView listView = getView().findViewById(R.id.lvMainMenu);
        ArrayAdapter<ModelMainMenuItem> adapter = new MainMenuAdapter(getActivity());
        listView.setAdapter(adapter);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        display.getSize(screenSize);
    }

    private class MainMenuAdapter extends ArrayAdapter<ModelMainMenuItem> {

        MainMenuAdapter(@NonNull Context context) {
            super(context, R.layout.main_menu_item, viewModel.getListMainMenu());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ModelMainMenuItem mainMenuItem = getItem(position);

            if (mainMenuItem == null) return convertView;
            
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.main_menu_item, null);
            }

            ((TextView) convertView.findViewById(R.id.main_menu_btn_title))
                    .setText(mainMenuItem.getTitle());

            ImageView btnImage = convertView.findViewById(R.id.main_menu_btn_img);
            btnImage.setImageResource(mainMenuItem.getImage());

            if (screenSize.y <= LOW_SCREEN_HEIGHT) {
                btnImage.getLayoutParams().height = 130;
            }

            convertView.setOnClickListener(mainMenuItem.getListener());

            return convertView;
        }
    }
}
