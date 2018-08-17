package com.creative.tmdb.listener;

import android.content.Context;
import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class ShowMovieDetailListener implements View.OnClickListener {

    private Context context;
    private int movieId;

    public ShowMovieDetailListener(Context context, int movieId) {
        this.context = context;
        this.movieId = movieId;
    }

    @Override
    public void onClick(View v) {
        Navigate.toMovieDetail(context, movieId);
    }
}
