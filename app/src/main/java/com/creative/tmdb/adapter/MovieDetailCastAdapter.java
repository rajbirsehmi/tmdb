package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCast;
import com.creative.tmdb.parser.CastParser;
import com.creative.tmdb.pojomapping.CastMember;
import com.creative.tmdb.viewholder.MovieDetailCastViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailCastAdapter extends RecyclerView.Adapter<MovieDetailCastViewHolder> {

    JsonMovieCreditCast[] castMembers;

    public MovieDetailCastAdapter(JsonMovieCreditCast[] castMembers) {
        this.castMembers = castMembers;
    }

    @NonNull
    @Override
    public MovieDetailCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_movie_detail_cast_crew, parent, false);
        return new MovieDetailCastViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailCastViewHolder holder, int position) {
        CastMember castMember = CastParser.parse(castMembers[position]);
        holder.bindDataToView(castMember);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
