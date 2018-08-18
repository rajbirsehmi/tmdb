package com.creative.tmdb.adapter;

import android.view.ViewGroup;

import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailGalleryPosterAdapter extends RecyclerView.Adapter {

    private JsonMovieDetailWallpaperAndPoster[] posters;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return posters.length;
    }
}
