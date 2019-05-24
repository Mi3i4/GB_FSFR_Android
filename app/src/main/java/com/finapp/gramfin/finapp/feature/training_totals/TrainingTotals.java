package com.finapp.gramfin.finapp.feature.training_totals;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainingTotals extends Fragment {

    @BindView(R.id.totals_text) TextView textView;

    private TrainingTotalsViewModel viewModel;

    public static TrainingTotals newInstance() {
        return new TrainingTotals();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.training_totals_fragment, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String str = bundle.getString(getContext().getString(R.string.router_tag));
            if (str != null) {
                textView.setText(str);
            }
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.training_title);

        viewModel = ViewModelProviders.of(this).get(TrainingTotalsViewModel.class);
        ButterKnife.bind(viewModel, getView());
    }
}
