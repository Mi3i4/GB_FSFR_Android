package com.finapp.gramfin.finapp.feature.main_menu_fragment;

import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.feature.second_screen.view.FragmentChapterSeliction;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;

public class MainMenuViewModel extends ViewModel {
    public void startTraining() {
        FragmentRouter.getInstance().placeFragment(FragmentChapterSeliction.class);
    }
}
