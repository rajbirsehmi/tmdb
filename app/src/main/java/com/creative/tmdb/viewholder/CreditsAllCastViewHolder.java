package com.creative.tmdb.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.pojomapping.CastMember;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CreditsAllCastViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivImagePoster;
    private TextView tvActorName;

    public CreditsAllCastViewHolder(@NonNull View itemView) {
        super(itemView);
        ivImagePoster = itemView.findViewById(R.id.iv_cast_crew);
        tvActorName = itemView.findViewById(R.id.tv_actor_name);
    }

    public void bindDataToView(CastMember castMember) {
        Glide.with(itemView.getContext())
                .load(itemView.getContext().getResources().getString(R.string.poster_url_prefix) + castMember.getProfileImageUrl())
                .into(ivImagePoster);
        tvActorName.setText(castMember.getActorName());
    }
}
