package com.creative.tmdb.listener;

import android.view.View;
import android.widget.Toast;

import com.creative.tmdb.R;
import com.creative.tmdb.permissioncheck.Permission;
import com.creative.tmdb.utils.Navigate;

public class DownloadServiceListener implements View.OnClickListener {

    private String url;

    public DownloadServiceListener(String url) {
        this.url = url;
    }

    @Override
    public void onClick(View v) {
        if (!Permission.checkIfGranted(v.getContext())) {
            Toast.makeText(v.getContext(), v.getContext().getResources().getString(R.string.toast_permission_denied), Toast.LENGTH_SHORT).show();
            return;
        }
        Navigate.toDownloadService(v.getContext(), url);
    }
}
