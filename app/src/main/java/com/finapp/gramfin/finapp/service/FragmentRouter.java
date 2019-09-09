package com.finapp.gramfin.finapp.service;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.finapp.gramfin.finapp.R;

public class FragmentRouter {
    private static FragmentRouter instance = null;
    private static Context context;
    private static FragmentManager fragmentManager;

    public static FragmentRouter getInstance() {
        if(instance == null) {
            instance = new FragmentRouter();
        }

        return instance;
    }

    private FragmentRouter() {}

    private FragmentManager getSupportFragmentManager() {
        return fragmentManager;
    }

    public void setContext(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public String getString(int id) {
        return context.getString(id);
    }

    public void notImplementedToast() {
        Toast.makeText(context, context.getString(R.string.under_construction), Toast.LENGTH_SHORT).show();
    }
    
    public void placeFragment(@NonNull Class<?> cls, @Nullable Bundle bundle) {
        Fragment fragment = getSupportFragmentManager().getFragmentFactory().instantiate(ClassLoader.getSystemClassLoader(), cls.getName());

        if (bundle != null) fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragments, fragment, "fragment")
                .addToBackStack(null)
                .commit();
    }


    public void curtainOn(View dim){
        dim.setVisibility(View.VISIBLE);

    }
    public void curtainOff(View dim) {
        dim.setVisibility(View.GONE);
    }
}
