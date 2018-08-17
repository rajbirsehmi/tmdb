package com.creative.tmdb.view;

import android.os.Bundle;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.PopularMovieSeeAllAdapter;
import com.creative.tmdb.model.PopularMoviesPagingImpl;
import com.creative.tmdb.presenter.PopularMoviesPaging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SeeAllPopularMovieActivity extends AppCompatActivity implements PopularMoviesPaging {

    private RecyclerView rvPopularMovies;
    private PopularMoviesPagingImpl popularMoviesPaging;
    private TextView tvMetadataPage, tvMetadataResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_popular_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvMetadataPage = findViewById(R.id.tv_metadata_pages);
        tvMetadataResults = findViewById(R.id.tv_metadata_results);

        rvPopularMovies = findViewById(R.id.rv_popular_movies);
        rvPopularMovies.setItemAnimator(new DefaultItemAnimator());
        rvPopularMovies.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        popularMoviesPaging = new PopularMoviesPagingImpl(this, getBaseContext());
        popularMoviesPaging.loadPopularMovies(1);

        findViewById(R.id.fab_next_page).setOnClickListener((view) -> {
            popularMoviesPaging.loadNextPage();
        });
        findViewById(R.id.fab_prev_page).setOnClickListener((view) -> {
            popularMoviesPaging.loadPrevPage();
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
    public void setPopularMovieAdapterToRecyclerView(PopularMovieSeeAllAdapter popularMovieSeeAllAdapter) {
        rvPopularMovies.setAdapter(popularMovieSeeAllAdapter);
    }

    @Override
    public void updateMetadata(int currentPage, int totalPages, int totalResults, int currentResultMax, int currentResultMin) {
        tvMetadataPage.setText("Displaying " + currentPage + " of " + totalPages + " Page(s)");
        tvMetadataResults.setText("Displaying " + currentResultMin + " to " + currentResultMax + " of " + totalResults + " Movies");
    }

    @Override
    public void notifyAlreadyAtFirstPage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
