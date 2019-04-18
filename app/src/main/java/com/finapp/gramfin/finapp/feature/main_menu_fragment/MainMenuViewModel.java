package com.finapp.gramfin.finapp.feature.main_menu_fragment;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.main_menu_fragment.model.ModelMainMenuItem;
import com.finapp.gramfin.finapp.feature.second_screen.view.FragmentChapterSeliction;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;

import java.util.ArrayList;
import java.util.List;

public class MainMenuViewModel extends ViewModel {

    private List<ModelMainMenuItem> listMainMenu = new ArrayList<>();

    public void setupModel() {
        if (listMainMenu.size() > 0) { return; }

        listMainMenu.add(new ModelMainMenuItem(R.drawable.agenda, R.string.btn_start_learning_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement кнопка "Изучение" нажата
                FragmentRouter.getInstance().notImplementedToast();
            }
        }));

        listMainMenu.add(new ModelMainMenuItem(R.drawable.strong, R.string.btn_start_training_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentRouter.getInstance().placeFragment(FragmentChapterSeliction.class);
            }
        }));

        listMainMenu.add(new ModelMainMenuItem(R.drawable.gym, R.string.btn_start_exam_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement кнопка "Экзамен" нажата
                FragmentRouter.getInstance().notImplementedToast();
            }
        }));

        listMainMenu.add(new ModelMainMenuItem(R.drawable.list, R.string.btn_statistic_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement кнопка "Статистика" нажата
                FragmentRouter.getInstance().notImplementedToast();
            }
        }));

        listMainMenu.add(new ModelMainMenuItem(R.drawable.bookmark, R.string.btn_favorites_text, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement кнопка "Избранное" нажата
                FragmentRouter.getInstance().notImplementedToast();
            }
        }));
    }

    public List<ModelMainMenuItem> getListMainMenu() {
        return listMainMenu;
    }

}
