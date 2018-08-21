package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.animation.Anim;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCrew;
import com.creative.tmdb.parser.CrewParser;
import com.creative.tmdb.pojomapping.CrewMember;
import com.creative.tmdb.viewholder.CreditsAllCrewViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CreditsAllCrewAdapter extends RecyclerView.Adapter<CreditsAllCrewViewHolder> {

    private JsonMovieCreditCrew[] crewMembers;

    public CreditsAllCrewAdapter(JsonMovieCreditCrew[] crewMembers) {
        this.crewMembers = crewMembers;
    }

    @NonNull
    @Override
    public CreditsAllCrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_movie_credit_crew, parent, false);
        return new CreditsAllCrewViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditsAllCrewViewHolder holder, int position) {
        CrewMember crewMember = CrewParser.parse(crewMembers[position]);
        Anim.setFadeInAnimation(holder.itemView);
        holder.bindDataToViews(crewMember);
    }

    @Override
    public int getItemCount() {
        return crewMembers.length;
    }
}
