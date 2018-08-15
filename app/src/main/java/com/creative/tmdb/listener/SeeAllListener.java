package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.R;
import com.creative.tmdb.utils.Navigate;

public class SeeAllListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_see_all_popular_movies:
                Navigate.toAllPopularMovies(v.getContext());
                break;
        }
    }
}
