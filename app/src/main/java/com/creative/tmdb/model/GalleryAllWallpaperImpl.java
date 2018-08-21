package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieGalleryWallpaperAdapter;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailImage;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.presenter.GalleryAllWallpaper;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallMovieImages;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GalleryAllWallpaperImpl {

    private GalleryAllWallpaper wallpaper;
    private Context context;
    private Retrofit retrofit;

    public GalleryAllWallpaperImpl(GalleryAllWallpaper wallpaper, Context context) {
        this.wallpaper = wallpaper;
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
                        JsonMovieDetailWallpaperAndPoster[] wallpapers = jsonMovieDetailImage.getJsonMovieDetailWallpapers();
                        wallpaper.setAllWallpaperGaleryAdapterToRecyclerView(new MovieGalleryWallpaperAdapter(wallpapers));
                    }

                    @Override
                    public void onFailure(Call<JsonMovieDetailImage> call, Throwable t) {
                        // on error
                    }
                });
    }
}
