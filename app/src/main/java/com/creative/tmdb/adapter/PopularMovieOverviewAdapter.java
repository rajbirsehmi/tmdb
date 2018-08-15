package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.animation.Anim;
import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMapping;
import com.creative.tmdb.parser.PopularMovieParser;
import com.creative.tmdb.pojomapping.PopularMovie;
import com.creative.tmdb.viewholder.PopularMovieOverviewViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMovieOverviewAdapter extends RecyclerView.Adapter<PopularMovieOverviewViewHolder> {

    private JsonPopularMovieMapping[] movieMappings;

    public PopularMovieOverviewAdapter(JsonPopularMovieMapping[] movieMappings) {
        this.movieMappings = movieMappings;
    }

    @NonNull
    @Override
    public PopularMovieOverviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View customView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_popular_movies_overview, parent, false);
        return new PopularMovieOverviewViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieOverviewViewHolder holder, int position) {
        PopularMovie popularMovie = PopularMovieParser.parseMovie(movieMappings[position]);
        Anim.setFadeInAnimation(holder.itemView);
        holder.bindDataToViews(popularMovie);
    }

    @Override
    public int getItemCount() {
        return movieMappings.length;
    }
}
