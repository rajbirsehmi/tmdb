package com.creative.tmdb.listener;

import android.view.View;

import com.creative.tmdb.utils.Navigate;

public class OpenCastMemberDetail implements View.OnClickListener {

    private String creditId;

    public OpenCastMemberDetail(String creditId) {
        this.creditId = creditId;
    }

    @Override
    public void onClick(View v) {
        Navigate.toCastMember(v.getContext(), creditId);
    }
}
