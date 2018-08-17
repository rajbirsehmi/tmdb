package com.creative.tmdb.view;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.creative.tmdb.R;
import com.creative.tmdb.fragments.CelebsFragment;
import com.creative.tmdb.fragments.HomeFragment;
import com.creative.tmdb.fragments.MovieFragment;
import com.creative.tmdb.fragments.TvShowFragment;
import com.creative.tmdb.listener.FragmentChangeListener;
import com.creative.tmdb.presenter.FragmentProcessor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentProcessor {

    private BottomNavigationView bnvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnvCategories = findViewById(R.id.bnv_categories);
        bnvCategories.setOnNavigationItemSelectedListener(new FragmentChangeListener(this));
    }

    @Override
    public void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_container, new HomeFragment()).commit();
        bnvCategories.getMenu().findItem(R.id.mi_home).setChecked(true);
    }

    @Override
    public void setMovieFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_container, new MovieFragment()).commit();
        bnvCategories.getMenu().findItem(R.id.mi_movies).setChecked(true);
    }

    @Override
    public void setTvShowFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_container, new TvShowFragment()).commit();
        bnvCategories.getMenu().findItem(R.id.mi_tv_shows).setChecked(true);
    }

    @Override
    public void setCelebsFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_container, new CelebsFragment()).commit();
        bnvCategories.getMenu().findItem(R.id.mi_celebs).setChecked(true);
    }

    @Override
    public void removeChildViews() {
        ((LinearLayout) findViewById(R.id.ll_container)).removeAllViews();
    }
}
