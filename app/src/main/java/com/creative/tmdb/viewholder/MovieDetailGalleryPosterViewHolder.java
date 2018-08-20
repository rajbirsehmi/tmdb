package com.creative.tmdb.viewholder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.listener.DownloadServiceListener;
import com.creative.tmdb.pojomapping.Image;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailGalleryPosterViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivPoster;
    private TextView tvVoteAverage;
    private ImageButton btnDownload;

    public MovieDetailGalleryPosterViewHolder(@NonNull View itemView) {
        super(itemView);
        ivPoster = itemView.findViewById(R.id.iv_gallery_image);
        tvVoteAverage = itemView.findViewById(R.id.tv_gallery_vote_average);
        btnDownload = itemView.findViewById(R.id.btn_download);
    }

    public void bindDataToView(Image poster) {
        String imageUrl = itemView.getContext().getResources().getString(R.string.poster_url_prefix) + poster.getImageUrl();
        String imageUrlDownload = itemView.getContext().getResources().getString(R.string.poster_url_prefix_high) + poster.getImageUrl();
        Glide
                .with(itemView.getContext())
                .load(imageUrl)
                .into(ivPoster);
        tvVoteAverage.setText(poster.getVoteAverage() + " ("+poster.getVoteCount()+" Votes)");
        btnDownload.setOnClickListener(new DownloadServiceListener(imageUrlDownload));
    }
}
