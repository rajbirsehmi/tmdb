package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class SeeAllWallpaperListener implements View.OnClickListener {

    private int movieId;

    public SeeAllWallpaperListener(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onClick(View v) {
        Navigate.toGalleryAllWallpaper(v.getContext(), movieId);
    }
}
