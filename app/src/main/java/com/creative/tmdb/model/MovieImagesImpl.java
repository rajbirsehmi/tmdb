package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieDetailPosterAdapter;
import com.creative.tmdb.adapter.MovieDetailWallpaperAdapter;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailImage;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.presenter.MovieImages;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallMovieImages;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieImagesImpl {

    private MovieImages movieImages;
    private Context context;
    private Retrofit retrofit;

    public MovieImagesImpl(MovieImages movieImages, Context context) {
        this.movieImages = movieImages;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadWallpapersAndPoster(int movieId) {
        retrofit
                .create(CallMovieImages.class)
                .getMovieImages(movieId, context.getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<JsonMovieDetailImage>() {
                    @Override
                    public void onResponse(Call<JsonMovieDetailImage> call, Response<JsonMovieDetailImage> response) {
                        JsonMovieDetailImage jsonMovieDetailImage = response.body();
                        JsonMovieDetailWallpaperAndPoster[] posters = jsonMovieDetailImage.getJsonMovieDetailPosters();
                        JsonMovieDetailWallpaperAndPoster[] wallpapers = jsonMovieDetailImage.getJsonMovieDetailWallpapers();
                        movieImages.setAdapterToPosterRecyclerView(new MovieDetailPosterAdapter(posters));
                        movieImages.setAdapterToWallpaperRecyclerView(new MovieDetailWallpaperAdapter(wallpapers));
                    }

                    @Override
                    public void onFailure(Call<JsonMovieDetailImage> call, Throwable t) {
                        // On Error
                    }
                });
    }
}
