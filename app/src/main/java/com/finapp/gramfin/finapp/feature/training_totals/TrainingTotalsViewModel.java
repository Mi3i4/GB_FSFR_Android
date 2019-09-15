package com.finapp.gramfin.finapp.feature.training_totals;

import android.view.View;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.BR;
import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.service.FragmentRouter;

import butterknife.OnClick;

public class TrainingTotalsViewModel extends ViewModel implements Observable {
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();
    private static TrainingTotalsViewModel instance = null;
    private String totals = FragmentRouter.getInstance().getString(R.string.totals_text);

    public static TrainingTotalsViewModel getInstance() {
        if(instance == null) {
            instance = new TrainingTotalsViewModel();
        }

        return instance;
    }

    @Bindable public String getTotals() { return totals; }

    public void setTotals(String totals) {
        this.totals = totals;
        registry.notifyChange(this, BR._all);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.totals_button_home:
                //TODO implement action on training totals fragment btn home pressed
                FragmentRouter.getInstance().notImplementedToast();
                break;
            case R.id.totals_button_repeat:
                //TODO implement action on training totals fragment btn repeat pressed
                FragmentRouter.getInstance().notImplementedToast();
                break;
            default:
                FragmentRouter.getInstance().notImplementedToast();
        }
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        instance = this;

        registry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.remove(callback);
    }
}
