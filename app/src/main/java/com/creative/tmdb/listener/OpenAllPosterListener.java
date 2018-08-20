package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class OpenAllPosterListener implements View.OnClickListener {

    private int movieId;

    public OpenAllPosterListener(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onClick(View v) {
        Navigate.openGalleryAllPoster(v.getContext(), movieId);
    }
}
