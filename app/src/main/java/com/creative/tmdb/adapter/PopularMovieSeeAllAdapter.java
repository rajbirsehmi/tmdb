package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.animation.Anim;
import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMapping;
import com.creative.tmdb.parser.PopularMovieParser;
import com.creative.tmdb.pojomapping.PopularMovie;
import com.creative.tmdb.viewholder.PopularMovieSeeAllViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMovieSeeAllAdapter extends RecyclerView.Adapter<PopularMovieSeeAllViewHolder> {

    private JsonPopularMovieMapping[] mappings;

    public PopularMovieSeeAllAdapter(JsonPopularMovieMapping[] mappings) {
        this.mappings = mappings;
    }

    @NonNull
    @Override
    public PopularMovieSeeAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_popular_movies_see_all, parent, false);
        return new PopularMovieSeeAllViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieSeeAllViewHolder holder, int position) {
        PopularMovie popularMovie = PopularMovieParser.parseMovie(mappings[position]);
        Anim.setFadeInAnimation(holder.itemView);
        holder.bindDataToViews(popularMovie);
    }

    @Override
    public int getItemCount() {
        return mappings.length;
    }
}
