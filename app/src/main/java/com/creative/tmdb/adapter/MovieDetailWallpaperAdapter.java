package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.parser.ImageParser;
import com.creative.tmdb.pojomapping.Image;
import com.creative.tmdb.viewholder.MovieDetailWallpaperViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailWallpaperAdapter extends RecyclerView.Adapter<MovieDetailWallpaperViewHolder> {

    private JsonMovieDetailWallpaperAndPoster[] wallpapers;

    public MovieDetailWallpaperAdapter(JsonMovieDetailWallpaperAndPoster[] wallpapers) {
        this.wallpapers = wallpapers;
    }

    @NonNull
    @Override
    public MovieDetailWallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_movie_images_wallpaper, parent, false);
        return new MovieDetailWallpaperViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailWallpaperViewHolder holder, int position) {
        Image wallpaper = ImageParser.parse(wallpapers[position]);
        holder.bindDataToView(wallpaper);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
