package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.parser.ImageParser;
import com.creative.tmdb.pojomapping.Image;
import com.creative.tmdb.viewholder.MovieDetailPosterViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailPosterAdapter extends RecyclerView.Adapter<MovieDetailPosterViewHolder> {

    private JsonMovieDetailWallpaperAndPoster[] posters;

    public MovieDetailPosterAdapter(JsonMovieDetailWallpaperAndPoster[] posters) {
        this.posters = posters;
    }

    @NonNull
    @Override
    public MovieDetailPosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_movie_images_poster, parent, false);
        return new MovieDetailPosterViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailPosterViewHolder holder, int position) {
        Image poster = ImageParser.parse(posters[position]);
        holder.bindDataToView(poster);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
