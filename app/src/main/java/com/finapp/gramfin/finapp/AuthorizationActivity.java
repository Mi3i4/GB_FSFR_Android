package com.finapp.gramfin.finapp;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.finapp.gramfin.finapp.feature.authorization_fragment.view.CustomAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthorizationActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager2 viewPager2;
    TabLayoutMediator tabLayoutMediator;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        ButterKnife.bind(this);
        adapter = new CustomAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                viewPager2.setCurrentItem(position);
                if (position==0)
                    tab.setText("Регистрация");
                if (position==1)
                    tab.setText("Авторизация");
                adapter.createFragment(position);
            }
        });
        tabLayoutMediator.attach();

    }
}

