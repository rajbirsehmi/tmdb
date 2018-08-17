package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetail;
import com.creative.tmdb.presenter.MovieDetail;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallMovieDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieDetailImpl {

    private MovieDetail movieDetail;
    private Context context;
    private Retrofit retrofit;

    public MovieDetailImpl(MovieDetail movieDetail, Context context) {
        this.movieDetail = movieDetail;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadDetail(int movieId) {
        retrofit
                .create(CallMovieDetail.class)
                .callMovieDetail(movieId, context.getString(R.string.API_KEY))
                .enqueue(new Callback<JsonMovieDetail>() {
                    @Override
                    public void onResponse(Call<JsonMovieDetail> call, Response<JsonMovieDetail> response) {
                        JsonMovieDetail detail = response.body();
                        movieDetail.setWidePoster(context.getResources().getString(R.string.poster_url_prefix) + detail.getWidePosterPath());
                        movieDetail.setMovieTitle(detail.getTitle());
                        movieDetail.setVoteAverage(detail.getVoteAverage());
                        movieDetail.setVoteCount(detail.getVoteCount());
                        movieDetail.setPopularity(detail.getPopularity());
                        movieDetail.setReleaseDate(detail.getReleaseDate());
                        movieDetail.setOverview(detail.getOverview());
                        movieDetail.setImdbListener(detail.getImdbId());
                    }

                    @Override
                    public void onFailure(Call<JsonMovieDetail> call, Throwable t) {
                        // For errors
                    }
                });
    }
}
