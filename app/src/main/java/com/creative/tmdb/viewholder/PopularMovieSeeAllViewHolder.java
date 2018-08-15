package com.creative.tmdb.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.creative.tmdb.R;
import com.creative.tmdb.pojomapping.PopularMovie;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMovieSeeAllViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivPoster;
    private TextView tvTitle, tvVoteAverage, tvVoteCount, tvPopularity, tvReleaseDate;
    private Context context;
    private RequestOptions requestOptions;

    public PopularMovieSeeAllViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        ivPoster = itemView.findViewById(R.id.iv_movie_poster_portrait);
        tvTitle = itemView.findViewById(R.id.tv_movie_title);
        tvVoteAverage = itemView.findViewById(R.id.tv_movie_vote_average);
        tvVoteCount = itemView.findViewById(R.id.tv_movie_vote_count);
        tvPopularity = itemView.findViewById(R.id.tv_movie_popularity);
        tvReleaseDate = itemView.findViewById(R.id.tv_movie_release_date);
        requestOptions = new RequestOptions();
        requestOptions.override((int) context.getResources().getDimension(R.dimen.poster_portrait_see_all_width), (int) context.getResources().getDimension(R.dimen.poster_portrait_see_all_width));
    }

    public void bindDataToViews(PopularMovie popularMovie) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions)
                .load(Uri.parse(context.getResources().getString(R.string.poster_url_prefix) + popularMovie.getPosterPath()))
                .into(ivPoster);
        tvVoteCount.setText(Integer.toString(popularMovie.getVoteCount()));
        tvTitle.setText(popularMovie.getTitle());
        tvVoteAverage.setText(Float.toString(popularMovie.getVoteAverage()));
        tvPopularity.setText(Float.toString(popularMovie.getPopularity()));
        tvReleaseDate.setText(popularMovie.getReleaseDate());
    }
}
