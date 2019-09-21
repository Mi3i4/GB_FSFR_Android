package com.finapp.gramfin.finapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;

import com.finapp.gramfin.finapp.feature.favourites.FavouritesFragment;
import com.finapp.gramfin.finapp.feature.second_screen.view.FragmentChapterSeliction;
import com.finapp.gramfin.finapp.feature.settings.SettingsFragment;
import com.finapp.gramfin.finapp.feature.statistics.wrong_answers.WrongAnswersFragment;
import com.finapp.gramfin.finapp.service.DisposableManager;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.finapp.gramfin.finapp.feature.main_menu_fragment.MainMenuFragment;

import com.finapp.gramfin.finapp.service.FragmentRouter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawerMenu(toolbar);


        FragmentRouter.getInstance().setContext(this, getSupportFragmentManager());
        FragmentRouter.getInstance().placeFragment(MainMenuFragment.class, null);
    }


    private void initDrawerMenu(Toolbar toolbar) {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnSearchClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View back_dim_layout = findViewById(R.id.dim_layout);
                        FragmentRouter.getInstance().curtainOn(back_dim_layout);
                    }
                });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO: Implement the search submit
                FragmentRouter.getInstance().notImplementedToast();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO: Implement the search query change
                return false;
            }
        });

        EditText searchSrcText = searchView.findViewById(R.id.search_src_text);
        searchSrcText.setTextColor(getResources().getColor(R.color.colorSearchText, null));
        searchSrcText.setHintTextColor(getResources().getColor(R.color.colorSearchTintBlack, null));
        ImageView searchCloseButton = searchView.findViewById(R.id.search_close_btn);
        searchCloseButton.setImageResource(R.drawable.search_clr);
        searchCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View back_dim_layout = findViewById(R.id.dim_layout);
                FragmentRouter.getInstance().curtainOff(back_dim_layout);
                searchView.setQuery("", false);
                searchView.clearFocus();
                searchView.setIconified(true);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        item.setChecked(true);

        if (id == R.id.learning) {
            bundle.putString(getString(R.string.title_tag), "ИЗУЧЕНИЕ");
            FragmentRouter.getInstance().placeFragment(FragmentChapterSeliction.class, bundle);

        } else if (id == R.id.training) {
            bundle.putString(getString(R.string.title_tag), "ТРЕНИРОВКА");
            FragmentRouter.getInstance().placeFragment(FragmentChapterSeliction.class, bundle);

        } else if (id == R.id.exam) {
            FragmentRouter.getInstance().notImplementedToast();
        } else if (id == R.id.statistics) {
            FragmentRouter.getInstance().placeFragment(WrongAnswersFragment.class, null);
        } else if (id == R.id.bookmark) {
            FragmentRouter.getInstance().placeFragment(FavouritesFragment.class, null);
        } else if (id == R.id.settings) {
            FragmentRouter.getInstance().placeFragment(SettingsFragment.class, null);
        } else if (id == R.id.add_friends) {
            FragmentRouter.getInstance().notImplementedToast();
        } else if (id == R.id.write_us) {
            FragmentRouter.getInstance().notImplementedToast();
        } else if (id == R.id.exit) {
            FragmentRouter.getInstance().notImplementedToast();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        DisposableManager.dispose();
        super.onDestroy();
    }
}
