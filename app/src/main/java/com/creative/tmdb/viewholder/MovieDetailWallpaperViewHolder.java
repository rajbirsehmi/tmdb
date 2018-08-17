package com.creative.tmdb.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.pojomapping.Image;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetailWallpaperViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivPoster;

    public MovieDetailWallpaperViewHolder(@NonNull View itemView) {
        super(itemView);
        ivPoster = itemView.findViewById(R.id.iv_movie_detail_wallpaper);
    }

    public void bindDataToView(Image wallpaper) {
        Glide.with(itemView.getContext())
                .load(Uri.parse(itemView.getContext().getResources().getString(R.string.poster_url_prefix)) + wallpaper.getImageUrl())
                .into(ivPoster);
    }
}
