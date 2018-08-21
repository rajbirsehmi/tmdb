package com.creative.tmdb.adapter;

import android.view.ViewGroup;

import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCrew;
import com.creative.tmdb.viewholder.MovieCreditsCrewViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieCreditsCrewAdapter extends RecyclerView.Adapter<MovieCreditsCrewViewHolder> {

    JsonMovieCreditCrew[] crewMembers;

    public MovieCreditsCrewAdapter(JsonMovieCreditCrew[] crewMembers) {
        this.crewMembers = crewMembers;
    }

    @NonNull
    @Override
    public MovieCreditsCrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCreditsCrewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
