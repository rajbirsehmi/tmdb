package com.creative.tmdb.utils;

import android.content.Context;
import android.content.Intent;

import com.creative.tmdb.SeeAllPopularMovieActivity;

public class Navigate {
    public static void toAllPopularMovies(Context context) {
        Intent intent = new Intent(context, SeeAllPopularMovieActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
