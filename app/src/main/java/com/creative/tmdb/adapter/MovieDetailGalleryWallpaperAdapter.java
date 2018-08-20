package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.animation.Anim;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.parser.ImageParser;
import com.creative.tmdb.pojomapping.Image;
import com.creative.tmdb.viewholder.MovieDetailGalleryWallpaperViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailGalleryWallpaperAdapter extends RecyclerView.Adapter<MovieDetailGalleryWallpaperViewHolder> {

    private JsonMovieDetailWallpaperAndPoster[] wallpaper;

    public MovieDetailGalleryWallpaperAdapter(JsonMovieDetailWallpaperAndPoster[] wallpaper) {

        this.wallpaper = wallpaper;
    }

    @NonNull
    @Override
    public MovieDetailGalleryWallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_gallery, parent, false);
        return new MovieDetailGalleryWallpaperViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailGalleryWallpaperViewHolder holder, int position) {
        Image poster = ImageParser.parse(wallpaper[position]);
        Anim.setFadeInAnimation(holder.itemView);
        holder.bindDataToView(poster);
    }

    @Override
    public int getItemCount() {
        return wallpaper.length;
    }
}
