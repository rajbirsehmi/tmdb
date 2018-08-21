package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class SeeAllPosterListener implements View.OnClickListener {

    private int movieId;

    public SeeAllPosterListener(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onClick(View v) {
        Navigate.toGalleryAllPoster(v.getContext(), movieId);
    }
}
