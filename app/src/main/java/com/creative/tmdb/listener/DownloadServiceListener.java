package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class DownloadServiceListener implements View.OnClickListener {

    private String url;

    public DownloadServiceListener(String url) {
        this.url = url;
    }

    @Override
    public void onClick(View v) {
        Navigate.toDownloadService(v.getContext(), url);
    }
}
