package com.finapp.gramfin.finapp.feature.authorization_fragment.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class CustomAdapter extends FragmentStateAdapter {




    private String[] tabTitles = new String[]{"Авторизация", "Регистрация"};



    public CustomAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new AuthFragment();
            case 0:
                return new RegFragment();
            default:
                return null;
        }    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

