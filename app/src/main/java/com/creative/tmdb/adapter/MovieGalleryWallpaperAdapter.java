package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.animation.Anim;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.parser.ImageParser;
import com.creative.tmdb.pojomapping.Image;
import com.creative.tmdb.viewholder.MovieGalleryWallpaperViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieGalleryWallpaperAdapter extends RecyclerView.Adapter<MovieGalleryWallpaperViewHolder> {

    private JsonMovieDetailWallpaperAndPoster[] wallpaper;

    public MovieGalleryWallpaperAdapter(JsonMovieDetailWallpaperAndPoster[] wallpaper) {

        this.wallpaper = wallpaper;
    }

    @NonNull
    @Override
    public MovieGalleryWallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_gallery, parent, false);
        return new MovieGalleryWallpaperViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieGalleryWallpaperViewHolder holder, int position) {
        Image poster = ImageParser.parse(wallpaper[position]);
        Anim.setFadeInAnimation(holder.itemView);
        holder.bindDataToView(poster);
    }

    @Override
    public int getItemCount() {
        return wallpaper.length;
    }
}
