package com.finapp.gramfin.finapp.feature.main_menu_fragment.model;

import android.view.View;

public class ModelMainMenuItem {
    final int image;
    final int title;
    final View.OnClickListener listener;

    public ModelMainMenuItem(int image, int title, View.OnClickListener listener) {
        this.image = image;
        this.title = title;
        this.listener = listener;
    }

    public int getImage() {
        return image;
    }
    public int getTitle() {
        return title;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

}
