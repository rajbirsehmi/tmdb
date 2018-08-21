package com.creative.tmdb.adapter;

import android.view.ViewGroup;

import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCast;
import com.creative.tmdb.viewholder.MovieCreditsCastViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieCreditsCastAdapter extends RecyclerView.Adapter<MovieCreditsCastViewHolder> {

    JsonMovieCreditCast[] castMembers;

    public MovieCreditsCastAdapter(JsonMovieCreditCast[] castMembers) {
        this.castMembers = castMembers;
    }

    @NonNull
    @Override
    public MovieCreditsCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCreditsCastViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
