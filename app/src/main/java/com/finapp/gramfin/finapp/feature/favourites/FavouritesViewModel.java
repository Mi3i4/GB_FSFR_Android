package com.finapp.gramfin.finapp.feature.favourites;

import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.favourites.model.FavouritesModel;
import com.finapp.gramfin.finapp.service.FragmentRouter;

import java.util.ArrayList;
import java.util.List;

public class FavouritesViewModel extends ViewModel {

    private List<FavouritesModel> favouritesModelArrayList = new ArrayList<>();

    public void setupModel() {
        if (favouritesModelArrayList.size() > 0) { return; }

        //TODO implement list of favorites
        for (int i = 0; i < 4; i++) {
            favouritesModelArrayList.add(new FavouritesModel(
                    FragmentRouter.getInstance().getString(R.string.chapter_holder),
                    FragmentRouter.getInstance().getString(R.string.question_holder),
                    v ->  FragmentRouter.getInstance().notImplementedToast()
            ));
        }
    }

    public List<FavouritesModel> getFavouritesModelArrayList() { return favouritesModelArrayList; }
}
