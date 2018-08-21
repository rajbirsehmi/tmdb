package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieGalleryPosterAdapter;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailImage;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.presenter.GalleryAllPoster;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallMovieImages;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GalleryAllPosterImpl {

    private GalleryAllPoster poster;
    private Context context;
    private Retrofit retrofit;

    public GalleryAllPosterImpl(GalleryAllPoster poster, Context context) {
        this.poster = poster;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadAllPosters(int movieId) {
        retrofit.create(CallMovieImages.class)
                .getMovieImages(movieId, context.getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<JsonMovieDetailImage>() {
                    @Override
                    public void onResponse(Call<JsonMovieDetailImage> call, Response<JsonMovieDetailImage> response) {
                        JsonMovieDetailImage jsonMovieDetailImage = response.body();
                        JsonMovieDetailWallpaperAndPoster[] posters = jsonMovieDetailImage.getJsonMovieDetailPosters();
                        poster.setAllPosterGaleryAdapterToRecyclerView(new MovieGalleryPosterAdapter(posters));
                    }

                    @Override
                    public void onFailure(Call<JsonMovieDetailImage> call, Throwable t) {
                        // on error
                    }
                });
    }
}
