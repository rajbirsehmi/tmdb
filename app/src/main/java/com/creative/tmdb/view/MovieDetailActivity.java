package com.creative.tmdb.view;

import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.model.MovieDetailImpl;
import com.creative.tmdb.presenter.MovieDetail;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetail {

    private ImageView ivWidePoster;
    private TextView tvVoteCount;
    private TextView tvVoteAverage;
    private TextView tvPopularity;
    private TextView tvReleaseDate;
    private TextView tvOverview;

    private MovieDetailImpl movieDetail;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        ivWidePoster = findViewById(R.id.iv_movie_poster_wide);
        tvVoteCount = findViewById(R.id.tv_movie_vote_count);
        tvVoteAverage = findViewById(R.id.tv_movie_vote_average);
        tvPopularity = findViewById(R.id.tv_movie_popularity);
        tvReleaseDate = findViewById(R.id.tv_movie_release_date);
        tvOverview = findViewById(R.id.tv_movie_overview);

        movieDetail = new MovieDetailImpl(this, getBaseContext());
        movieDetail.loadDetail(getIntent().getIntExtra("movie_id", -1));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setWidePoster(String widePosterUrl) {
        Glide.with(getBaseContext())
                .load(Uri.parse(widePosterUrl))
                .into(ivWidePoster);
    }

    @Override
    public void setMovieTitle(String movieTitle) {
        collapsingToolbarLayout.setTitle(movieTitle);
    }

    @Override
    public void setVoteCount(long voteCount) {
        tvVoteCount.setText("Count : " + voteCount);
    }

    @Override
    public void setVoteAverage(float voteAverage) {
        tvVoteAverage.setText(voteAverage + " / 10.0");
    }

    @Override
    public void setPopularity(float popularity) {
        tvPopularity.setText("Popularity\n" + Float.toString(popularity));
    }

    @Override
    public void setReleaseDate(String releaseDate) {
        tvReleaseDate.setText("Release Date\n" + releaseDate);
    }

    @Override
    public void setOverview(String overview) {
        tvOverview.setText(overview);
    }
}