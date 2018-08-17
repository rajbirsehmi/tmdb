package com.creative.tmdb.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.creative.tmdb.R;
import com.creative.tmdb.listener.ShowMovieDetailListener;
import com.creative.tmdb.pojomapping.PopularMovie;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMovieOverviewViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivPoster;
    private TextView tvTitle;
    private Context context;
    private RequestOptions requestOptions;

    public PopularMovieOverviewViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        ivPoster = itemView.findViewById(R.id.iv_movie_poster_portrait);
        tvTitle = itemView.findViewById(R.id.tv_movie_title);
        requestOptions = new RequestOptions();
        requestOptions.override((int) context.getResources().getDimension(R.dimen.poster_portrait_width), (int) context.getResources().getDimension(R.dimen.poster_portrait_height));
    }

    public void bindDataToViews(PopularMovie popularMovie, ShowMovieDetailListener showMovieDetailListener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions)
                .load(Uri.parse(context.getResources().getString(R.string.poster_url_prefix) + popularMovie.getPosterPath()))
                .into(ivPoster);
        tvTitle.setText(popularMovie.getTitle());
        itemView.setOnClickListener(showMovieDetailListener);
    }
}
