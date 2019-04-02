package com.finapp.gramfin.finapp.frag_router;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

    public void notImplementedToast() {
        Toast.makeText(context, context.getString(R.string.under_construction), Toast.LENGTH_SHORT).show();
    }

    public void placeFragment(@NonNull Class<?> cls) {
        Fragment fragment = Fragment.instantiate(context, cls.getName(),null);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.drawer_layout, fragment, "fragment")
                .addToBackStack(null)
                .commit();
    }
}
