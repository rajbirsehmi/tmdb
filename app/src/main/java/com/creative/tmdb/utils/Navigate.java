package com.creative.tmdb.utils;

import android.content.Context;
import android.content.Intent;

import com.creative.tmdb.downloadservice.DownloadService;
import com.creative.tmdb.view.GalleryPosterActivity;
import com.creative.tmdb.view.GalleryWallpaperActivity;
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

    public static void openGalleryAllPoster(Context context, int movieId) {
        Intent intent = new Intent(context, GalleryPosterActivity.class);
        intent.putExtra("movie_id", movieId);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void openGalleryAllWallpaper(Context context, int movieId) {
        Intent intent = new Intent(context, GalleryWallpaperActivity.class);
        intent.putExtra("movie_id", movieId);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toDownloadService(Context context, String url) {
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra("url", url);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(intent);
    }
}
