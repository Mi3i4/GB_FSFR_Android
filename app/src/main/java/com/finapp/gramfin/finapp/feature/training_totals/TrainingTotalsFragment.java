package com.finapp.gramfin.finapp.feature.training_totals;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.databinding.TrainingTotalsFragmentBinding;

public class TrainingTotalsFragment extends Fragment {

    private TrainingTotalsViewModel viewModel;

    public static TrainingTotalsFragment newInstance() {
        return new TrainingTotalsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.training_totals_fragment, container, false);

        viewModel = new ViewModelProvider(this).get(TrainingTotalsViewModel.class);
        TrainingTotalsFragmentBinding.bind(view).setViewModel(viewModel);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.training_title);
    }
}
