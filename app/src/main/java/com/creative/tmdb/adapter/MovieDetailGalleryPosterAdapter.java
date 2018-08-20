package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.animation.Anim;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.parser.ImageParser;
import com.creative.tmdb.pojomapping.Image;
import com.creative.tmdb.viewholder.MovieDetailGalleryPosterViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailGalleryPosterAdapter extends RecyclerView.Adapter<MovieDetailGalleryPosterViewHolder> {

    private JsonMovieDetailWallpaperAndPoster[] posters;

    public MovieDetailGalleryPosterAdapter(JsonMovieDetailWallpaperAndPoster[] posters) {
        this.posters = posters;
    }

    @NonNull
    @Override
    public MovieDetailGalleryPosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_gallery, parent, false);
        return new MovieDetailGalleryPosterViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailGalleryPosterViewHolder holder, int position) {
        Image poster = ImageParser.parse(posters[position]);
        Anim.setFadeInAnimation(holder.itemView);
        holder.bindDataToView(poster);
    }


    @Override
    public int getItemCount() {
        return posters.length;
    }
}
