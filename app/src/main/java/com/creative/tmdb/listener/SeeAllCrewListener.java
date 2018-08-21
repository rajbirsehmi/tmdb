package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class SeeAllCrewListener implements View.OnClickListener {

    private int movieId;

    public SeeAllCrewListener(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onClick(View v) {
        Navigate.toSeeAllCrew(v.getContext(), movieId);
    }
}
