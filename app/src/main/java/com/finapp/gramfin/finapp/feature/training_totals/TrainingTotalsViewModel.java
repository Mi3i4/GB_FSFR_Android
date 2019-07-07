package com.finapp.gramfin.finapp.feature.training_totals;

import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;

import butterknife.OnClick;

public class TrainingTotalsViewModel extends ViewModel {

    @OnClick({R.id.totals_button_home, R.id.totals_button_repeat})
    public void onClick() {
        FragmentRouter.getInstance().notImplementedToast();
    }
}
