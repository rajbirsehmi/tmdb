package com.creative.tmdb.utils;

import android.content.Context;
import android.content.Intent;

import com.creative.tmdb.view.MovieDetailActivity;
import com.creative.tmdb.view.SeeAllPopularMovieActivity;

public class Navigate {
    public static void toAllPopularMovies(Context context) {
        Intent intent = new Intent(context, SeeAllPopularMovieActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toMovieDetail(Context context, int movieId) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra("movie_id", movieId);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
