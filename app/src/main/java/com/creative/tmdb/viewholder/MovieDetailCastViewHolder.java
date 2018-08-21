package com.creative.tmdb.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.pojomapping.CastMember;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailCastViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivCast;

    public MovieDetailCastViewHolder(@NonNull View itemView) {
        super(itemView);
        ivCast = itemView.findViewById(R.id.iv_cast_crew);
    }

    public void bindDataToView(CastMember castMember) {
        Glide.with(itemView.getContext())
                .load(itemView.getContext().getResources().getString(R.string.poster_url_prefix) + castMember.getProfileImageUrl())
                .into(ivCast);
    }
}
