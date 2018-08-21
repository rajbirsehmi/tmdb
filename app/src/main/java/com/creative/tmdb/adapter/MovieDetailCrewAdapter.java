package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCrew;
import com.creative.tmdb.parser.CrewParser;
import com.creative.tmdb.pojomapping.CrewMember;
import com.creative.tmdb.viewholder.MovieDetailCrewViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailCrewAdapter extends RecyclerView.Adapter<MovieDetailCrewViewHolder> {

    JsonMovieCreditCrew[] crewMembers;

    public MovieDetailCrewAdapter(JsonMovieCreditCrew[] crewMembers) {
        this.crewMembers = crewMembers;
    }

    @NonNull
    @Override
    public MovieDetailCrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_movie_detail_cast_crew, parent, false);
        return new MovieDetailCrewViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailCrewViewHolder holder, int position) {
        CrewMember crewMember = CrewParser.parse(crewMembers[position]);
        holder.bindDataToView(crewMember);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
