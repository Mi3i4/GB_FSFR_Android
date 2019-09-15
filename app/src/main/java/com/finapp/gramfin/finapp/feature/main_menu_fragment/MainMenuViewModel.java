package com.finapp.gramfin.finapp.feature.main_menu_fragment;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.favourites.FavouritesFragment;
import com.finapp.gramfin.finapp.feature.main_menu_fragment.model.ModelMainMenuItem;
import com.finapp.gramfin.finapp.feature.second_screen.view.FragmentChapterSeliction;
import com.finapp.gramfin.finapp.feature.statistics.wrong_answers.WrongAnswersFragment;
import com.finapp.gramfin.finapp.service.FragmentRouter;

import java.util.ArrayList;
import java.util.List;

public class MainMenuViewModel extends ViewModel {

    private List<ModelMainMenuItem> listMainMenu = new ArrayList<>();

    public void setupModel() {
        if (listMainMenu.size() > 0) { return; }
        Bundle bundle = new Bundle();
        listMainMenu.add(new ModelMainMenuItem(R.drawable.main_menu_agenda, R.string.btn_start_learning_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("title_tag","ИЗУЧЕНИЕ");
                FragmentRouter.getInstance().placeFragment(FragmentChapterSeliction.class, bundle);
            }
        }));
        listMainMenu.add(new ModelMainMenuItem(R.drawable.main_menu_strong, R.string.btn_start_training_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("title_tag","ТРЕНИРОВКА");
                FragmentRouter.getInstance().placeFragment(FragmentChapterSeliction.class, bundle);
            }
        }));

        listMainMenu.add(new ModelMainMenuItem(R.drawable.main_menu_gym, R.string.btn_start_exam_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement кнопка "Экзамен" нажата
                FragmentRouter.getInstance().notImplementedToast();
            }
        }));

        listMainMenu.add(new ModelMainMenuItem(R.drawable.main_menu_list, R.string.btn_statistic_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement кнопка "Статистика" нажата
                FragmentRouter.getInstance().placeFragment(WrongAnswersFragment.class, null);
            }
        }));

        listMainMenu.add(new ModelMainMenuItem(R.drawable.main_menu_bookmark, R.string.btn_favorites_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentRouter.getInstance().placeFragment(FavouritesFragment.class, null);
            }
        }));
    }

    public List<ModelMainMenuItem> getListMainMenu() {
        return listMainMenu;
    }

}
