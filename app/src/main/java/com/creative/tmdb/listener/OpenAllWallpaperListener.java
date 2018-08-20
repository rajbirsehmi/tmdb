package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class OpenAllWallpaperListener implements View.OnClickListener {

    private int movieId;

    public OpenAllWallpaperListener(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onClick(View v) {
        Navigate.openGalleryAllWallpaper(v.getContext(), movieId);
    }
}
