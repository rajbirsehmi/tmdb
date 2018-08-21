package com.creative.tmdb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.CreditsAllCastAdapter;
import com.creative.tmdb.model.CreditsSeeAllCastImpl;
import com.creative.tmdb.presenter.CreditsSeeAllCast;

public class CreditsAllCastActivity extends AppCompatActivity implements CreditsSeeAllCast {

    private RecyclerView rvCredits;
    private CreditsSeeAllCastImpl creditsSeeAllCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cast);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_credits_all_cast));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvCredits = findViewById(R.id.rv_credits);
        rvCredits.setItemAnimator(new DefaultItemAnimator());
        rvCredits.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));

        creditsSeeAllCast = new CreditsSeeAllCastImpl(this, getBaseContext());
        creditsSeeAllCast.loadAllCastMembers(getIntent().getIntExtra("movie_id", -1));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setCastAdapter(CreditsAllCastAdapter castAdapter) {
        rvCredits.setAdapter(castAdapter);
    }
}