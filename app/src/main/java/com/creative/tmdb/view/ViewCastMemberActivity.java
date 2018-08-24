package com.creative.tmdb.view;

import android.os.Bundle;
import android.view.MenuItem;

import com.creative.tmdb.R;
import com.creative.tmdb.model.ViewCastDetailImpl;
import com.creative.tmdb.presenter.ViewCastDetail;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ViewCastMemberActivity extends AppCompatActivity implements ViewCastDetail {

    private String creditId;

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private ViewCastDetailImpl viewCastDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cast);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        creditId = getIntent().getStringExtra("credit_id");

        viewCastDetail = new ViewCastDetailImpl(this, getBaseContext());
        viewCastDetail.getCastMemberDetail(creditId);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
