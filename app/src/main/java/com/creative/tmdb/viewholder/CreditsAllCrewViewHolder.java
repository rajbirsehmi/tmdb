package com.creative.tmdb.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.pojomapping.CrewMember;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CreditsAllCrewViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivPosterImage;
    private TextView tvNameAndJobTitle;

    public CreditsAllCrewViewHolder(@NonNull View itemView) {
        super(itemView);
        ivPosterImage = itemView.findViewById(R.id.iv_cast_crew);
        tvNameAndJobTitle = itemView.findViewById(R.id.tv_name_job_title);
    }

    public void bindDataToViews(CrewMember member) {
        tvNameAndJobTitle.setText(member.getCrewMemberName() + " (" + member.getDepartment() + ")");
        if (member.getProfileImageUrl() == null) {
            Glide.with(itemView.getContext())
                    .load(itemView.getContext().getResources().getDrawable(R.drawable.img_movie_detail_see_all_cast_crew_no_preview_available))
                    .into(ivPosterImage);
            return;
        }
        Glide.with(itemView.getContext())
                .load(itemView.getContext().getResources().getString(R.string.poster_url_prefix) + member.getProfileImageUrl())
                .into(ivPosterImage);
    }
}
