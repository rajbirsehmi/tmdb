package com.creative.tmdb.listener;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.creative.tmdb.R;

public class ImdbLinkListener implements View.OnClickListener {

    private String imdbId;

    public ImdbLinkListener(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public void onClick(View v) {
        Intent intentImdb = new Intent(Intent.ACTION_VIEW, Uri.parse(v.getContext().getResources().getString(R.string.imdb_base_url) + imdbId));
        intentImdb.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        v.getContext().startActivity(intentImdb);
    }
}
