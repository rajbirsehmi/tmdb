package com.creative.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.animation.Anim;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCast;
import com.creative.tmdb.parser.CastParser;
import com.creative.tmdb.pojomapping.CastMember;
import com.creative.tmdb.viewholder.CreditsAllCastViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CreditsAllCastAdapter extends RecyclerView.Adapter<CreditsAllCastViewHolder> {

    JsonMovieCreditCast[] castMembers;

    public CreditsAllCastAdapter(JsonMovieCreditCast[] castMembers) {
        this.castMembers = castMembers;
    }

    @NonNull
    @Override
    public CreditsAllCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_movie_credit_cast, parent, false);
        return new CreditsAllCastViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditsAllCastViewHolder holder, int position) {
        CastMember castMember = CastParser.parse(castMembers[position]);
        Anim.setFadeInAnimation(holder.itemView);
        holder.bindDataToView(castMember);
    }

    @Override
    public int getItemCount() {
        return castMembers.length;
    }
}
