package com.creative.tmdb.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creative.tmdb.R;
import com.creative.tmdb.listener.ImdbCastMemberLinkListener;
import com.creative.tmdb.model.ViewCastBiodataImpl;
import com.creative.tmdb.model.ViewCastDetailImpl;
import com.creative.tmdb.presenter.ViewCastBiodata;
import com.creative.tmdb.presenter.ViewCastDetail;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ViewCastMemberActivity extends AppCompatActivity implements ViewCastDetail, ViewCastBiodata {

    private String creditId;

    private ImageView ivWidePoster;
    private TextView tvDepartmentName;
    private TextView tvPopularity;
    private TextView tvPlaceOfBirth;
    private TextView tvBiography;
    private TextView tvDateOfBirth;

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private ViewCastDetailImpl viewCastDetail;
    private ViewCastBiodataImpl viewCastBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cast);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        ivWidePoster = findViewById(R.id.iv_cast_member_poster_wide);
        tvDepartmentName = findViewById(R.id.tv_department);
        tvPopularity = findViewById(R.id.tv_cast_member_popularity);
        tvPlaceOfBirth = findViewById(R.id.tv_cast_member_place_of_birth);
        tvBiography = findViewById(R.id.tv_cast_member_biography);
        tvDateOfBirth = findViewById(R.id.tv_cast_member_date_of_birth);

        creditId = getIntent().getStringExtra("credit_id");

        viewCastDetail = new ViewCastDetailImpl(this, getBaseContext());
        viewCastDetail.getCastMemberDetail(creditId);

        viewCastBiodata = new ViewCastBiodataImpl(this, getBaseContext());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setBackgroundImage(String posterUrl) {
        Glide.with(getBaseContext())
                .load(posterUrl)
                .into(ivWidePoster);
    }

    @Override
    public void setCastMemberName(String actorName) {
        collapsingToolbarLayout.setTitle(actorName);
    }

    @Override
    public void setCastMemberDepartment(String department) {
        tvDepartmentName.setText(department);
    }

    @Override
    public void setCastMemberPopularity(float popularity) {
        tvPopularity.setText(Float.toString(popularity));
    }

    @Override
    public void loadMoreData(int personId) {
        viewCastBiodata.getBiodata(personId);
    }

    @Override
    public void setBirthDate(String birthday) {
        tvDateOfBirth.setText(birthday);
    }

    @Override
    public void setBirthPlace(String birthPlace) {
        tvPlaceOfBirth.setText(birthPlace);
    }

    @Override
    public void setBiography(String biography) {
        tvBiography.setText(biography);
    }

    @Override
    public void setImdbLink(ImdbCastMemberLinkListener linkListener) {
        findViewById(R.id.ll_open_link_in_imdb).setOnClickListener(linkListener);
    }
}
