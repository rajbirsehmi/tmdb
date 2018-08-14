package com.creative.tmdb.listener;

import android.view.MenuItem;

import com.creative.tmdb.R;
import com.creative.tmdb.presenter.FragmentProcessor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;

public class FragmentChangeListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentProcessor fragmentProcessor;

    public FragmentChangeListener(FragmentProcessor fragmentProcessor) {
        this.fragmentProcessor = fragmentProcessor;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mi_home:
                fragmentProcessor.setHomeFragment();
                break;
            case R.id.mi_movies:
                fragmentProcessor.setMovieFragment();
                break;
            case R.id.mi_tv_shows:
                break;
            case R.id.mi_celebs:
                break;
        }
        return false;
    }
}
