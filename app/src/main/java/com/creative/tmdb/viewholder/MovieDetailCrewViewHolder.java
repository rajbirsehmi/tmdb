package com.creative.tmdb.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.pojomapping.CastMember;
import com.creative.tmdb.pojomapping.CrewMember;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailCrewViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivCrew;

    public MovieDetailCrewViewHolder(@NonNull View itemView) {
        super(itemView);
        ivCrew = itemView.findViewById(R.id.iv_cast_crew);
    }

    public void bindDataToView(CrewMember crewMember) {
        if (crewMember.getProfileImageUrl() == null) {
            Glide.with(itemView.getContext())
                    .load(itemView.getContext().getResources().getDrawable(R.drawable.img_movie_detail_see_all_cast_crew_no_preview_available))
                    .into(ivCrew);
            return;
        }
        Glide.with(itemView.getContext())
                .load(itemView.getContext().getResources().getString(R.string.poster_url_prefix) + crewMember.getProfileImageUrl())
                .into(ivCrew);
    }
}
