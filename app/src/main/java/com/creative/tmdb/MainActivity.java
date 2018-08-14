package com.creative.tmdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.creative.tmdb.fragments.HomeFragment;
import com.creative.tmdb.fragments.MovieFragment;
import com.creative.tmdb.listener.FragmentChangeListener;
import com.creative.tmdb.presenter.FragmentProcessor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements FragmentProcessor {

    private BottomNavigationView bnvCategories;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnvCategories = findViewById(R.id.bnv_categories);
        bnvCategories.setOnNavigationItemSelectedListener(new FragmentChangeListener(this));
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void setHomeFragment() {
        fragmentTransaction.replace(R.id.fl_container, new HomeFragment()).commit();
        bnvCategories.setSelectedItemId(R.id.mi_home);
    }

    @Override
    public void setMovieFragment() {
        fragmentTransaction.replace(R.id.fl_container, new MovieFragment()).commit();
        bnvCategories.setSelectedItemId(R.id.mi_movies);
    }

    @Override
    public void setTvShowFragment() {

    }

    @Override
    public void setCelebsFragment() {

    }
}
