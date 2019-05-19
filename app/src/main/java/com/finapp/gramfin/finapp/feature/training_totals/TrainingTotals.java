package com.finapp.gramfin.finapp.feature.training_totals;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finapp.gramfin.finapp.R;

import butterknife.ButterKnife;

public class TrainingTotals extends Fragment {

    private TrainingTotalsViewModel viewModel;

    public static TrainingTotals newInstance() {
        return new TrainingTotals();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.training_totals_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.training_title);

        viewModel = ViewModelProviders.of(this).get(TrainingTotalsViewModel.class);
        ButterKnife.bind(viewModel, getView());
    }
}
