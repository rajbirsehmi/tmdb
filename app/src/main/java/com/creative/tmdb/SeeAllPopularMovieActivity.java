package com.creative.tmdb;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import com.creative.tmdb.adapter.PopularMovieOverviewAdapter;
import com.creative.tmdb.model.LoadPopularMoviesImpl;
import com.creative.tmdb.presenter.LoadPopularMovies;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;

public class SeeAllPopularMovieActivity extends AppCompatActivity implements LoadPopularMovies {

    private RecyclerView rvPopularMovies;
    private LoadPopularMoviesImpl loadPopularMovies;
    private int currentPage = 1;
    private int columnCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_popular_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvPopularMovies = findViewById(R.id.rv_popular_movies);
        rvPopularMovies.setItemAnimator(new DefaultItemAnimator());
        rvPopularMovies.setLayoutManager(new GridLayoutManager(getBaseContext(), columnCount));

        loadPopularMovies = new LoadPopularMoviesImpl(this, getBaseContext());
        loadPopularMovies.loadPopularMovies(currentPage);

        findViewById(R.id.fab_next_page).setOnClickListener((view) -> {
            currentPage++;
            loadPopularMovies.loadPopularMovies(currentPage);
        });
        findViewById(R.id.fab_prev_page).setOnClickListener((view) -> {
            if (currentPage == 1)
                return;
            currentPage--;
            loadPopularMovies.loadPopularMovies(currentPage);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPopularMovieAdapterToRecyclerView(PopularMovieOverviewAdapter popularMovieOverviewAdapter) {
        rvPopularMovies.setAdapter(popularMovieOverviewAdapter);
    }
}
