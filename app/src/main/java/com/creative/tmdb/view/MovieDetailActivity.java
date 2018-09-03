package com.creative.tmdb.view;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieDetailCastAdapter;
import com.creative.tmdb.adapter.MovieDetailCrewAdapter;
import com.creative.tmdb.adapter.MovieDetailPosterAdapter;
import com.creative.tmdb.adapter.MovieDetailWallpaperAdapter;
import com.creative.tmdb.listener.ImdbMovieLinkListener;
import com.creative.tmdb.listener.SeeAllCastListener;
import com.creative.tmdb.listener.SeeAllCrewListener;
import com.creative.tmdb.listener.SeeAllPosterListener;
import com.creative.tmdb.listener.SeeAllWallpaperListener;
import com.creative.tmdb.model.MovieCreditCastCrewImpl;
import com.creative.tmdb.model.MovieDetailImpl;
import com.creative.tmdb.model.MovieImagesImpl;
import com.creative.tmdb.presenter.MovieDetailCastCrew;
import com.creative.tmdb.presenter.MovieDetail;
import com.creative.tmdb.presenter.MovieDetailImages;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetail, MovieDetailImages, MovieDetailCastCrew {

    private ImageView ivWidePoster;
    private TextView tvVoteCount;
    private TextView tvVoteAverage;
    private TextView tvPopularity;
    private TextView tvReleaseDate;
    private TextView tvOverview;
    private RecyclerView rvWallpaper, rvPoster, rvCast, rvCrew;
    private LinearLayout llOpenLinkInImdb;

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private MovieDetailImpl movieDetail;
    private MovieImagesImpl movieImages;
    private MovieCreditCastCrewImpl movieCreditCastCrew;

    private int movieId;

    private DefaultItemAnimator defaultItemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movieId = getIntent().getIntExtra("movie_id", -1);

        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        defaultItemAnimator = new DefaultItemAnimator();

        ivWidePoster = findViewById(R.id.iv_movie_poster_wide);
        tvVoteCount = findViewById(R.id.tv_movie_vote_count);
        tvVoteAverage = findViewById(R.id.tv_movie_vote_average);
        tvPopularity = findViewById(R.id.tv_movie_popularity);
        tvReleaseDate = findViewById(R.id.tv_movie_release_date);
        tvOverview = findViewById(R.id.tv_movie_overview);
        llOpenLinkInImdb = findViewById(R.id.ll_open_link_in_imdb);

        findViewById(R.id.btn_see_all_movie_posters).setOnClickListener(new SeeAllPosterListener(movieId));
        findViewById(R.id.btn_see_all_movie_wallpapers).setOnClickListener(new SeeAllWallpaperListener(movieId));
        findViewById(R.id.btn_see_all_movie_cast).setOnClickListener(new SeeAllCastListener(movieId));
        findViewById(R.id.btn_see_all_movie_crew).setOnClickListener(new SeeAllCrewListener(movieId));

        rvPoster = findViewById(R.id.rv_movie_posters);
        rvPoster.setItemAnimator(defaultItemAnimator);
        rvPoster.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));

        rvWallpaper = findViewById(R.id.rv_movie_wallpapers);
        rvWallpaper.setItemAnimator(defaultItemAnimator);
        rvWallpaper.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));

        rvCast = findViewById(R.id.rv_movie_cast);
        rvCast.setItemAnimator(defaultItemAnimator);
        rvCast.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));

        rvCrew = findViewById(R.id.rv_movie_crew);
        rvCrew.setItemAnimator(defaultItemAnimator);
        rvCrew.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));

        movieDetail = new MovieDetailImpl(this, getBaseContext());
        movieDetail.loadDetail(movieId);

        movieImages = new MovieImagesImpl(this, getBaseContext());
        movieImages.loadWallpapersAndPoster(movieId);

        movieCreditCastCrew = new MovieCreditCastCrewImpl(this, getBaseContext());
        movieCreditCastCrew.loadCastAndCrew(movieId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
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

    @Override
    public void setImdbListener(String imdbId) {
        llOpenLinkInImdb.setOnClickListener(new ImdbMovieLinkListener(imdbId));
    }

    @Override
    public void setAdapterToWallpaperRecyclerView(MovieDetailWallpaperAdapter wallpaperAdapter) {
        rvWallpaper.setAdapter(wallpaperAdapter);
    }

    @Override
    public void setAdapterToPosterRecyclerView(MovieDetailPosterAdapter posterAdapter) {
        rvPoster.setAdapter(posterAdapter);
    }

    @Override
    public void setCastAdapter(MovieDetailCastAdapter castAdapter) {
        rvCast.setAdapter(castAdapter);
    }

    @Override
    public void setCrewAdapter(MovieDetailCrewAdapter crewAdapter) {
        rvCrew.setAdapter(crewAdapter);
    }
}