package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class SeeAllCastListener implements View.OnClickListener {

    private int movieId;

    public SeeAllCastListener(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onClick(View v) {
        Navigate.toSeeAllCast(v.getContext(), movieId);
    }
}
